package com.junli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lijun
 */
@EnableTransactionManagement
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("SpringBoot开始启动。。。。");
        SpringApplication.run(Application.class, args);
        System.out.println("SpringBoot启动成功");
    }
}