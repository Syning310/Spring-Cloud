package com.syning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

@EnableEurekaClient
@MapperScan("com.syning.mapper")
@SpringBootApplication
public class PaymentMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PaymentMain.class, args);

//        String[] names = context.getBeanNamesForType(PaymentMapper.class);
//
//        for (String name : names) {
//            System.out.println(name);     // paymentMapper
//        }

    }
}
