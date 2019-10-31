package codetask.fds.service;

import codetask.fds.model.request.Driver;
import codetask.fds.model.request.Race;
import codetask.fds.model.request.RacesResults;
import codetask.fds.model.request.Result;
import codetask.fds.model.response.WinnersNationalityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class TopWinnersService {

    @Autowired
    private RestTemplate restTemplate;


    public List<String> requestWinnersNationality(int year) {
        RacesResults quote = restTemplate.getForObject(
                "http://ergast.com/api/f1/" + year + "/results/1.json", RacesResults.class);
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
        return new TreeMap<>(allYearsWinners.stream().sorted().collect(Collectors.groupingBy(e -> e.toString(), Collectors.counting())));
    }

    public List<WinnersNationalityResponse> responseMapper(Map<String, Long> map) {
        List<WinnersNationalityResponse> list = new ArrayList<>();
        map.forEach((k, v) -> list.add(new WinnersNationalityResponse(k, v, list.size() + 1)));
        return list;
    }


}
