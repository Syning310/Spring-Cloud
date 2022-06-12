package com.syning;

import com.syning.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain18600 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrderMain18600.class, args);

//        String[] names = context.getBeanNamesForType(PaymentService.class);
//
//        int i = 0;
//        for (String name : names) {
//            System.out.println("第" + i++ + "个 = " + name);
//        }
//
//        Object bean = context.getBean("com.syning.service.PaymentService");
//
//        bean.getClass();


    }
}
