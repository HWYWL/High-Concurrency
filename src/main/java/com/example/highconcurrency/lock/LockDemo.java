package com.example.highconcurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁和synchronized对比
 * 100万以下数据synchronized优于Lock
 * 100万以上数据Lock优于synchronized
 * @author YI
 * @date 2018-8-14 15:50:35
 */
public class LockDemo {
	
	private static Lock lock = new ReentrantLock();
	private static int TEMP = 1000000;

	public static void main(String[] args) {
		lockDemo();
		SyncDemo();
	}

	public static void lockDemo(){
		long start = System.currentTimeMillis();
		for(int i = 0; i < TEMP; i++){
			final int num = i;
			((Runnable) () -> lock(num)).run();
		}

		long end = System.currentTimeMillis();
		System.out.println("lock 锁耗时：" + (end-start) + "ms");
	}

	public static void SyncDemo(){
		long start = System.currentTimeMillis();
		for(int i = 0; i < TEMP; i++){
			final int num = i;
			((Runnable) () -> sync(num)).run();
		}

		long end = System.currentTimeMillis();
		System.out.println("synchronized 锁耗时：" + (end-start) + "ms");
	}

    public static void lock(int i){
    	lock.lock();
    	lock.unlock();
    }

    public static synchronized void sync(int i){
    	
    }
}
