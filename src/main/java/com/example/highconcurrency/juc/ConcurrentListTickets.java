package com.example.highconcurrency.juc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ConcurrentListTickets {
    static List<String> list;
    static int COUNT = 100;

    static {
        list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= COUNT; i++) {
            list.add(i + "   这是第" + (COUNT - i) + "张票");
        }
    }

    public String shakedown() {
        synchronized (this) {
            COUNT -= 1;
            if (COUNT < 0) {
                String str = " 线程:[" + Thread.currentThread().getName() + "] 票已售完！！！";
                System.out.println(str);

                return str;
            }

            String str = " 线程:[" + Thread.currentThread().getName() + "] 剩余票数：" + list.get(COUNT);
            System.out.println(str);

            return str;
        }
    }
}
