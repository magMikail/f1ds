package codetask.fds.service;

import codetask.fds.model.request.Driver;
import codetask.fds.model.request.Race;
import codetask.fds.model.request.RacesResults;
import codetask.fds.model.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class TopWinnersService {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getWinnerNations(int year) {
        RacesResults quote = restTemplate.getForObject(
                "http://ergast.com/api/f1/" + year + "/results/1.json", RacesResults.class);

        return quote.getMRData().getRaceTable().getRaces().stream()
                .map(Race::getResults)
                .flatMap(List::stream)
                .map(Result::getDriver)
                .map(Driver::getNationality)
                .collect(Collectors.toList());
    }

    public Map<String, Long> sortedCount(List<String> winnersList) {
        Map<String, Long> unsortedCount = winnersList.stream().sorted().collect(Collectors.groupingBy(e -> e.toString(), Collectors.counting()));
        return new TreeMap<>(unsortedCount);
    }

}
