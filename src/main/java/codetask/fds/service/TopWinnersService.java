package codetask.fds.service;

import codetask.fds.model.response.Race;
import codetask.fds.model.response.RaceTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class TopWinnersService {
    private RestTemplate restTemplate;

    public TopWinnersService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Race> getRaces() {
        ResponseEntity<String> quote = restTemplate.getForEntity(
                "http://ergast.com/api/f1/2008/results/1.json", String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(quote.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode races = root.path("MRData").path("RaceTable");
        RaceTable raceTable = null;
        try {
            raceTable = new ObjectMapper().treeToValue(races, RaceTable.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return raceTable.getRaces();
    }

    public List<String> getNations() {
//        getRaces().stream().forEach(race -> race.getResults().stream().forEach(result -> result.getDriver().getNationality()));

        for (Race results : getRaces()) {
            System.out.println(results.getSeason());
        }
        return null;
    }


}
