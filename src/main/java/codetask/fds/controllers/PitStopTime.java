package codetask.fds.controllers;

import codetask.fds.model.response.PitStopTimeResponse;
import codetask.fds.service.PitStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pitStopTime")
public class PitStopTime {

    @Autowired
    PitStopService pitStopService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("{year}/{threshold}")
    public @ResponseBody
    List<PitStopTimeResponse> sendWinnersAllYears(@PathVariable int year, @PathVariable double threshold) {
        return pitStopService.getPitStops(year, threshold);
    }

    @GetMapping("{year}/{threshold}/csv")
    public @ResponseBody
    ResponseEntity<String> sendWinnersAllYearsCsv(@PathVariable int year, @PathVariable double threshold) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/plain; charset=utf-8");
        return new ResponseEntity<>(pitStopService.getPitStopsToString(year, threshold), responseHeaders, HttpStatus.OK);
    }

}
