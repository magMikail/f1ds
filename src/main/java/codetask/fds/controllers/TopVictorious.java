package codetask.fds.controllers;

import codetask.fds.model.response.WinnersNationalityResponse;
import codetask.fds.service.TopWinnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("topWinners")
public class TopVictorious {

    @Autowired
    TopWinnersService topWinnersService;

    @GetMapping("{startYear}/{finishYear}")
    public List<WinnersNationalityResponse> sendWinnersAllYears(@PathVariable int startYear, @PathVariable int finishYear) {

        return topWinnersService.responseMapper(topWinnersService.collectAllWinnersForYears(startYear, finishYear));
    }


}
