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

import java.util.ArrayList;
import java.util.List;

@Service
public class PitStopService {
    Logger log = LoggerFactory.getLogger(TopWinnersService.class);

    @Autowired
    private RestTemplate restTemplate;

    private List<PitStop> requestPitStop(int year, int threshold) {
        RacesResults quote;
        try {
            quote = restTemplate.getForObject(
                    "http://ergast.com/api/f1/" + year + "/" + threshold + "/pitstops.json", RacesResults.class
            );
        } catch (HttpClientErrorException ex) {
            log.info("Bad request for {} year ", year);
            throw new NotFoundException(year, year);
        }
        return quote.getMRData().getRaceTable().getRaces().get(0).getPitStops();
    }

    public List<PitStop> collectAllPitStops(int year) {
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

    public List<PitStopTimeResponse> responseMapper(List<PitStop> response) {
        List<PitStopTimeResponse> list = new ArrayList<>();
        PitStopTimeResponse ptr = new PitStopTimeResponse();

        response.forEach(i -> i.getDriverId());
        response.forEach(System.out::println);

        for (PitStop pitStop : response) {
            ptr.setDriver(ptr.getDriver());
        }
        return list;
    }

}
