package codetask.fds.controllers;

import codetask.fds.service.TopWinnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("topWinners")
public class TopVictorious {

    @Autowired
    TopWinnersService topWinnersService;

    @GetMapping
    public void getTopVictoriousNations(String initialYear, String finalYear) {
        System.out.println(topWinnersService.sortedCount(topWinnersService.getWinnerNations(2008)));
    }

    @GetMapping("{year}")
    public Map<String, Long> sendWinners(@PathVariable int year) {
        return topWinnersService.getSortedWinners(year);
    }

    @GetMapping("{startYear}/{finishYear}")
    public Map<String, Long> sendWinnersAllYears(@PathVariable int startYear, @PathVariable int finishYear) {

        return topWinnersService.getSortedWinnersForYears(startYear, finishYear);
    }

//    @GetMapping("{year}")
//    public WinnersNationalityResponse sendWinners2(@PathVariable String year) {
//
////        final ObjectMapper mapper = new ObjectMapper();
////        final WinnersNationalityResponse pojo=mapper.convertValue(topWinnersService.getSortedWinners(Integer.valueOf(year)), WinnersNationalityResponse);
//
//        return null;
//    }

//    @GetMapping("{year}")
//    public WinnersNationalityResponse sendWinners3(@PathVariable String year) {
//        return ResponseEntity.ok(topWinnersService.getSortedWinners(Integer.valueOf(year))
//                .entrySet()
//                .stream()
//                .map( g -> new WinnersNationalityResponse(g.getKey(), g.getValue()))
//                .collect(Collectors.toList()));
//    }
}
