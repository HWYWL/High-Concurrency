package com.yi.juc.queue;

import org.junit.Test;

/**
 * J.U.C包下的ConcurrentLinkedQueue测试单元
 * ConcurrentLinkedQueue是一个基于链接节点的无边界的线程安全队列，它采用FIFO原则对元素进行排序。采用“wait-free”算法（即CAS算法）来实现的。
 * @author YI
 * @date 2018-8-6 16:30:26
 */
public class ConcurrentLinkedQueueTest {
    @Test
    public void linkedQueueTest(){
        Multithreading multithreading = new Multithreading();
        multithreading.shakedown();
    }
}
