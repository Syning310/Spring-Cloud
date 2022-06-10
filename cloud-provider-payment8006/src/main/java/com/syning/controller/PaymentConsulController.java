package com.syning.controller;

import com.syning.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String testConsul() {
        log.info("**********work");
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }


    @GetMapping(value = "/timeout")
    public ResultEntity<String> timeout() {
        try {
            Thread.sleep(3000);
        }
        catch (Exception e) {
            return ResultEntity.failed("服务错误");
        }

        return ResultEntity.successWithData(serverPort);
    }


    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to here, O(∩_∩)O哈哈~";
    }

}
