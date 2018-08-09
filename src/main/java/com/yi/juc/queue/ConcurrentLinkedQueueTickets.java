package com.yi.juc.queue;

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
public class ConcurrentLinkedQueueTickets {
    public static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static{
        int count = 10000;
        for (int i = 1; i <= count; i++) {
            tickets.add(count - i + "   这是第" + i + "张票");
        }
    }

    public void shakedown() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                while (true) {
                    String ticket = tickets.poll();
                    if (ticket == null) break;

                    System.out.println(" 线程:[" + Thread.currentThread().getName() + "] 剩余票数：" + ticket);
                }
            });
        }
    }
}
