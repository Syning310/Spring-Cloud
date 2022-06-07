package com.syning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ProviderPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8006.class, args);
    }
}
