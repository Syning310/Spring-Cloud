package com.syning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaMain5001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain5001.class, args);
    }
}
