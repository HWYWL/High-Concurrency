package com.example.highconcurrency;

import com.example.highconcurrency.juc.ConcurrentLinkedQueueTickets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HighConcurrencyApplicationTests {

    @Test
    public void queueTickets() {
        ConcurrentLinkedQueueTickets tickets = new ConcurrentLinkedQueueTickets();
        tickets.shakedown();
    }

}
