package codetask.fds.service;


import codetask.fds.model.response.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopWinnersServiceTest {
    @Autowired
    private TopWinnersService topWinnersService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getResults() throws Exception {
        List<String> results = topWinnersService.getWinnerNations();
        for(String str : results){
            System.out.println(str);
        }
        Assert.assertEquals(18, results.size());
    }

}