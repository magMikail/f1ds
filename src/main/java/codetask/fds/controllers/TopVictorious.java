package codetask.fds.controllers;

import codetask.fds.service.TopWinnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopVictorious {

    @Autowired
    TopWinnersService topWinnersService;

    @RequestMapping("/")
//    @ResponseBody
    public void getTopVictoriousNations(String initialYear, String finalYear) {
        topWinnersService.getWinnerNations();
    }
}
