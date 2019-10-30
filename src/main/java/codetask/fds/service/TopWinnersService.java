package codetask.fds.service;

import codetask.fds.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopWinnersService {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getWinnerNations() {
        RacesResults quote = restTemplate.getForObject(
                "http://ergast.com/api/f1/2008/results/1.json", RacesResults.class);
        return quote.getMRData().getRaceTable().getRaces().stream()
                .map(Race::getResults)
                .flatMap(List::stream)
                .map(Result::getDriver)
                .map(Driver::getNationality)
                .collect(Collectors.toList());
    }


}
