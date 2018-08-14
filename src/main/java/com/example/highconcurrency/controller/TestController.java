package com.example.highconcurrency.controller;

import com.example.highconcurrency.juc.ConcurrentLinkedQueueTickets;
import com.example.highconcurrency.juc.ConcurrentListTickets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试接口
 * @author YI
 * @date 2018-8-10 15:40:31
 */
@Controller
@Slf4j
public class TestController {
    @Autowired
    ConcurrentListTickets concurrentListTickets;
    @Autowired
    ConcurrentLinkedQueueTickets concurrentLinkedQueueTickets;

    @RequestMapping("/concurrentLinkedQueueTickets")
    @ResponseBody
    public String concurrentLinkedQueueTickets() {
        concurrentLinkedQueueTickets.shakedown();

        return "concurrentLinkedQueueTickets";
    }

    @RequestMapping("/concurrentListTickets")
    @ResponseBody
    public String concurrentListTickets() {
        String shakedown = concurrentListTickets.shakedown();

        return shakedown;
    }
}
