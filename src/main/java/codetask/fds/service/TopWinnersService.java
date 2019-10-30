package codetask.fds.service;

import codetask.fds.model.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopWinnersService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Race> getRaces() {
        ResponseEntity<MRData> quote = restTemplate.getForEntity(
                "http://ergast.com/api/f1/2008/results/1.json", MRData.class);
        return quote.getBody().getRaceTable().getRaces();
    }

    public List<String> getNations() {
        return getRaces()
                .stream()
                .map(Race::getResults)
                .flatMap(List::stream)
                .map(Result::getDriver)
                .map(Driver::getNationality)
                .collect(Collectors.toList());
    }

}
