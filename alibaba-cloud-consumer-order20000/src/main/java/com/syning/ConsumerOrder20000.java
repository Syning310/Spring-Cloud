package com.syning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerOrder20000 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder20000.class, args);
    }
}
