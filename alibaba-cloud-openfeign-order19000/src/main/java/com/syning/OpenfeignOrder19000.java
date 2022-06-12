package com.syning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OpenfeignOrder19000 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrder19000.class, args);
    }
}
