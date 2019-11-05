package codetask.fds.service;

import codetask.fds.exceptions.NotFoundException;
import codetask.fds.model.request.common.RacesResults;
import codetask.fds.model.request.pitStops.PitStop;
import codetask.fds.model.response.PitStopTimeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PitStopService {
    Logger log = LoggerFactory.getLogger(TopWinnersService.class);

    @Autowired
    private RestTemplate restTemplate;

    private List<PitStop> requestPitStop(int year, int round) {
        RacesResults quote;
        try {
            quote = restTemplate.getForObject(
                    "http://ergast.com/api/f1/" + year + "/" + round + "/pitstops.json", RacesResults.class
            );
        } catch (HttpClientErrorException ex) {
            log.info("Bad request for {} year ", year);
            throw new NotFoundException(year, year);
        }
        return quote.getMRData().getRaceTable().getRaces().get(0).getPitStops();
    }

    private List<PitStop> collectAllPitStops(int year) {
        List<PitStop> allPitStops = new ArrayList<>();
//        todo replace with 'last' + get 'round' as a initial loop value
        for (int i = 20; i > 0; i--) {
            try {
                allPitStops.addAll(requestPitStop(year, i));
            } catch (IndexOutOfBoundsException ex) {
                continue;
            }
        }
        return allPitStops;
    }

    private Map<String, List<Double>> distinctDrivers(List<PitStop> allPitStops) {
        Map<String, List<Double>> result = new HashMap<>();
        List<String> drivers = allPitStops.stream()
                .map(PitStop::getDriverId)
                .distinct().collect(Collectors.toList());
        for (String s : drivers) {
            result.put(s, allPitStops.stream()
                    .filter(aps -> aps.getDriverId().equals(s))
                    .map(d -> d.getDuration()).
                            collect(Collectors.toList()));
        }
        return result;
    }

    private List<PitStopTimeResponse> responseMapper(Map<String, List<Double>> dDrivers) {
        List<PitStopTimeResponse> pitStopTimeResponseList = new ArrayList<>();
        for (Map.Entry<String, List<Double>> entry : dDrivers.entrySet()) {
            PitStopTimeResponse response = new PitStopTimeResponse();
            response.setDriver(entry.getKey());
            response.setFastestPitStopTime(entry.getValue().stream().mapToDouble(d -> d).min().getAsDouble());
            response.setSlowestPitStopTime(entry.getValue().stream().mapToDouble(d -> d).max().getAsDouble());
            response.setAveragePitStopTime(entry.getValue().stream().mapToDouble(d -> d).average().orElse(0.0));
            pitStopTimeResponseList.add(response);
        }
        return pitStopTimeResponseList;
    }

    private List<PitStopTimeResponse> rankPitStops(List<PitStopTimeResponse> unranked) {
        List<PitStopTimeResponse> sorted = unranked.stream().sorted(Comparator.comparing(PitStopTimeResponse::getFastestPitStopTime)).collect(Collectors.toList());
        int i = 1;
        for (PitStopTimeResponse pitStopTimeResponse : sorted) {
            pitStopTimeResponse.setRank(i);
            i++;
        }
        return sorted;
    }

    public List<PitStopTimeResponse> getPitStops(int year, double threshold) {
        List<PitStopTimeResponse> response = responseMapper(distinctDrivers(collectAllPitStops(year))).stream()
                .filter(aps -> aps.getAveragePitStopTime() < threshold)
                .collect(Collectors.toList());
        return rankPitStops(response);
    }

    public String getPitStopsToString(int year, double threshold) {
        return getPitStops(year, threshold).stream().map(w -> String.valueOf(w))
                .collect(Collectors.joining("\n"));
    }

}
