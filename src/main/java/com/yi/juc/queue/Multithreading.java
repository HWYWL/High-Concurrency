package com.yi.juc.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * J.U.C包下的ConcurrentLinkedQueue测试
 * ConcurrentLinkedQueue是一个基于链接节点的无边界的线程安全队列，它采用FIFO原则对元素进行排序。采用“wait-free”算法（即CAS算法）来实现的。
 * @author YI
 * @date 2018-8-6 16:33:40
 */
public class Multithreading {

    public void shakedown(){
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ConcurrentLinkedQueueTickets tickets = new ConcurrentLinkedQueueTickets();
        while (true){
            String ticket = tickets.degression();
            if(ticket == null) break;

            pool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t开始发车啦...."));
            pool.execute(() -> System.out.println(" 线程:[" + Thread.currentThread().getName() + "] 剩余票数：" + ticket));
        }
    }


}
