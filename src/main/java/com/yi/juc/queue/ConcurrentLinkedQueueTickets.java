package com.yi.juc.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * J.U.C包下的ConcurrentLinkedQueue测试
 * ConcurrentLinkedQueue是一个基于链接节点的无边界的线程安全队列，它采用FIFO原则对元素进行排序。采用“wait-free”算法（即CAS算法）来实现的。
 * @author YI
 * @date 2018-8-6 16:30:26
 */
public class ConcurrentLinkedQueueTickets {
    private static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static{
        int count = 10000;
        for (int i = 1; i <= count; i++) {
            tickets.add(count - i + "   这是第" + i + "张票");
        }
    }

    public String degression() {
        return tickets.poll();
    }
}
