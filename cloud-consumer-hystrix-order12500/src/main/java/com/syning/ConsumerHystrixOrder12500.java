package com.syning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableHystrix          //添加到此处
@EnableFeignClients     // 开启feign微服务组件
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerHystrixOrder12500 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixOrder12500.class, args);
    }
}
