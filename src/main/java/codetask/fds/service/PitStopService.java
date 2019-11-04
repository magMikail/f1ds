package codetask.fds.service;

import codetask.fds.exceptions.NotFoundException;
import codetask.fds.model.request.pitStops.PitStop;
import codetask.fds.model.request.pitStops.RacesResults;
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

    public List<PitStop> requestPitStopTime(int year, int threshold) {
        RacesResults quote;
        try {
            quote = restTemplate.getForObject(
                    "http://ergast.com/api/f1/" + year + "/last/pitstops.json", RacesResults.class
            );
        } catch (HttpClientErrorException ex) {
            log.info("Bad request for {} year ", year);
            throw new NotFoundException(year, year);
        }
        return quote.getmRData().getRaceTable().getRaces().get(0).getPitStops();
    }


    public List<PitStopTimeResponse> responseMapper(List<PitStop> response) {
        List<PitStopTimeResponse> list = new ArrayList<>();
        response.forEach(System.out::println);
        return list;
    }

}
