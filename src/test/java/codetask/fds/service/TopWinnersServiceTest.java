package codetask.fds.service;


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
    public void getWinnerNationsTest() throws Exception {
        List<String> results = topWinnersService.requestWinnersNationality(2008);
        System.out.println(results);
        Assert.assertEquals(18, results.size());
    }

//    @Test
//    public void getCountTest() throws Exception {
//        Map<String, Long> count = topWinnersService.sortedCount(topWinnersService.requestWinnersNationality(2008));
//
//        System.out.println(count);
//        Assert.assertEquals(6, count.size());
//    }

}