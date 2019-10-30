package codetask.fds.controllers;

import codetask.fds.service.TopWinnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopVictorious {

    @Autowired
    TopWinnersService topWinnersService;

    @GetMapping
    public void getTopVictoriousNations(String initialYear, String finalYear) {
        System.out.println("+++++++++1+++++++++");
        System.out.println(topWinnersService.sortedCount(topWinnersService.getWinnerNations(2008)));
    }

    @GetMapping("/{year}")
    public ResponseEntity<?> sendWinners(@PathVariable String year
//            , @RequestBody RacesResults request
    ) {
        System.out.println("====================");

        return ResponseEntity.ok(topWinnersService.sortedCount(topWinnersService.getWinnerNations(Integer.valueOf(year))));
    }
}
