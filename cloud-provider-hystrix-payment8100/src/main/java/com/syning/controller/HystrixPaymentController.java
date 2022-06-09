package com.syning.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.syning.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
public class HystrixPaymentController {

    @Resource(name = "paymentService")
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Long id) {
        String ret = paymentService.paymentInfo_OK(id);
        log.info("**********  ret = " + ret);
        return ret;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Long id) {
        String ret = paymentService.paymentInfo_failed(id);
        log.info("**********  ret = " + ret);
        return ret;
    }



    // ==== 服务熔断 ====
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("********** result = {}", result);
        return result;
    }


}
