package com.syning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ProviderPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment9001.class, args);
    }
}