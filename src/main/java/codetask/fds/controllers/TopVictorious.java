package codetask.fds.controllers;

import codetask.fds.model.response.WinnersNationalityResponse;
import codetask.fds.service.TopWinnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topWinners")
public class TopVictorious {

    @Autowired
    TopWinnersService topWinnersService;

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("{startYear}/{finishYear}")
    public List<WinnersNationalityResponse> sendWinnersAllYears(@PathVariable int startYear, @PathVariable int finishYear) {
        List<WinnersNationalityResponse> winnersResponse = topWinnersService.responseMapper(topWinnersService.collectAllWinnersForYears(startYear, finishYear));
        return winnersResponse;
    }

}
