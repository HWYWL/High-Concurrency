package com.example.highconcurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 高并发测试用例
 * @author YI
 * @date 2018-8-10 14:33:58
 */
@SpringBootApplication
public class HighConcurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighConcurrencyApplication.class, args);
    }
}
