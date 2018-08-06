package com.yi.juc.queue;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;

/**
 * J.U.C包下的ConcurrentLinkedQueue测试
 * ConcurrentLinkedQueue是一个基于链接节点的无边界的线程安全队列，它采用FIFO原则对元素进行排序。采用“wait-free”算法（即CAS算法）来实现的。
 * @author YI
 * @date 2018-8-6 16:33:40
 */
public class Multithreading {
    ExecutorService executor = ThreadUtil.newExecutor(10);

    public void shakedown(){
        ConcurrentLinkedQueueTickets tickets = new ConcurrentLinkedQueueTickets();
        Runnable task = () -> {
            while (true){
                String ticket = tickets.degression();
                if(ticket == null) break;

                System.out.println(" 线程:[" + Thread.currentThread().getName() + "] 剩余票数：" + ticket);
            }
        };

        // 开启多个线程进行抢票
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);
    }


}
