package codetask.fds.controllers;

import codetask.fds.model.response.PitStopTimeResponse;
import codetask.fds.service.PitStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    List<PitStopTimeResponse> sendWinnersAllYears(@PathVariable int year, @PathVariable int threshold) {
        return pitStopService.responseMapper(pitStopService.collectAllPitStops(year));
    }
}
