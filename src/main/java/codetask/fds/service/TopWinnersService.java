package codetask.fds.service;

import codetask.fds.exceptions.NotFoundException;
import codetask.fds.model.request.Driver;
import codetask.fds.model.request.Race;
import codetask.fds.model.request.RacesResults;
import codetask.fds.model.request.Result;
import codetask.fds.model.response.WinnersNationalityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class TopWinnersService {
    Logger log = LoggerFactory.getLogger(TopWinnersService.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<String> requestWinnersNationality(int year) {
        RacesResults quote;
        try {
            quote = restTemplate.getForObject(
                    "http://ergast.com/api/f1/" + year + "/results/1.json", RacesResults.class);
        } catch (HttpClientErrorException ex) {
            log.info("Bad request for {} year ", year);
            throw new NotFoundException(year, year);
        }

        log.info("consumed for '{}' year", year);
        return quote.getMRData().getRaceTable().getRaces().stream()
                .map(Race::getResults)
                .flatMap(List::stream)
                .map(Result::getDriver)
                .map(Driver::getNationality)
                .collect(Collectors.toList());
    }

    public Map<String, Long> collectAllWinnersForYears(int startYear, int finishYear) {
        List<String> allYearsWinners = new ArrayList<>();
        for (int i = startYear; i <= finishYear; i++) {
            allYearsWinners.addAll(requestWinnersNationality(i));
        }
        return new TreeMap<>(allYearsWinners.stream().sorted().collect(Collectors.groupingBy(String::toString, Collectors.counting())));
    }

    public List<WinnersNationalityResponse> responseMapper(Map<String, Long> map) {
        List<WinnersNationalityResponse> list = new ArrayList<>();
        map.forEach((k, v) -> list.add(new WinnersNationalityResponse(k, v, list.size() + 1)));
        if (!list.isEmpty() && list.size() > 10) {
            return list.subList(0, 10);
        }
        return list;
    }

    public String responseMapperToString(Map<String, Long> map) {
        return responseMapper(map).stream().map(w -> String.valueOf(w))
                .collect(Collectors.joining("\n"));
    }

}
