package com.syning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerOrderMain12000 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerOrderMain12000.class, args);
    }
}
