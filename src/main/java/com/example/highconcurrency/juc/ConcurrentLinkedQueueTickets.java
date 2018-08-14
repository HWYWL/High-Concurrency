package com.example.highconcurrency.juc;

import cn.hutool.core.thread.ThreadUtil;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * J.U.C包下的ConcurrentLinkedQueue测试
 * ConcurrentLinkedQueue是一个基于链接节点的无边界的线程安全队列，它采用FIFO原则对元素进行排序。采用“wait-free”算法（即CAS算法）来实现的。
 * @author YI
 * @date 2018-8-9 22:23:11
 */
@Service
public class ConcurrentLinkedQueueTickets {
    public static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static{
        int count = 10000;
        for (int i = 1; i <= count; i++) {
            tickets.add(count - i + "   这是第" + i + "张票");
        }
    }

    public String shakedown() {
        String ticket = tickets.poll();
        if (ticket == null) {
            String str = " 线程:[" + Thread.currentThread().getName() + "] 票已售完！！！";
            System.out.println(str);

            return str;
        }

        String str = " 线程:[" + Thread.currentThread().getName() + "] 剩余票数：" + ticket;
        System.out.println(str);

        return str;
    }
}
