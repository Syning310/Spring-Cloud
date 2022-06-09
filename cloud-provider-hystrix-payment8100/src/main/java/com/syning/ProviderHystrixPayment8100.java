package com.syning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableCircuitBreaker    // 开启回路，熔断
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderHystrixPayment8100 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPayment8100.class, args);
    }
}
