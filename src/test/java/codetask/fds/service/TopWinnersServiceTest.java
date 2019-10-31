package codetask.fds.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopWinnersServiceTest {
    @Autowired
    private TopWinnersService topWinnersService;

//    @Before
//    public void setUp() throws Exception {
//    }

    @Test
    public void consumedFromOutsideApi() {
        List<String> results = topWinnersService.requestWinnersNationality(2008);
        assert (results.size() == 18);
    }

    @Test
    public void consumedForFewYears() {
        Map<String, Long> winners = topWinnersService.collectAllWinnersForYears(2008, 2008);
        System.out.println(winners);
        Assert.assertEquals(6, winners.size());
    }

    @Test
    public void orderedAlphabetically() {
        Map<String, Long> expected = new HashMap<>();
        expected.put("Brazilian", 6L);
        expected.put("British", 5L);
        expected.put("Finnish", 3L);
        expected.put("German", 1L);
        expected.put("Polish", 1L);
        expected.put("Spanish", 2L);
        Map<String, Long> actual = topWinnersService.collectAllWinnersForYears(2008, 2008);
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void noMoreThan10() {
        Map<String, Long> map11 = new HashMap<>();
        map11.put("Brazilian", 6L);
        map11.put("British", 5L);
        map11.put("Finnish", 3L);
        map11.put("German", 1L);
        map11.put("Polish", 1L);
        map11.put("Spanish", 2L);
        map11.put("Portugal", 2L);
        map11.put("Italian", 2L);
        map11.put("India", 2L);
        map11.put("Ukraine", 2L);
        map11.put("Russia", 2L);
        Assert.assertEquals(10, topWinnersService.responseMapper(map11).size());
    }

}