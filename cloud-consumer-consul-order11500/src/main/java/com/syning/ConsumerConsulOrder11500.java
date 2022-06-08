package com.syning;


import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


//@RibbonClient(name = "consul-provider-payment", configuration = MySelfRule.class)
@EnableDiscoveryClient  // 该注解用于向使用consul或zookeeper作为注册中心时注册服务
@SpringBootApplication
public class ConsumerConsulOrder11500 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulOrder11500.class, args);
    }
}
