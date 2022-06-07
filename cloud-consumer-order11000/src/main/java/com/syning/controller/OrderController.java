package com.syning.controller;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    // 此处的订单服务写死了，所以负载均衡不会生效，每次都只会调用同一个
//    private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;



    @PostMapping (value = "/consumer/payment/save")
    public ResultEntity savePayment(Payment payment) {


        String requestMapping = "/payment/save";

        return restTemplate.postForObject(PAYMENT_URL + requestMapping, payment, ResultEntity.class);
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public ResultEntity getPaymentById(@PathVariable("id") Long id) {

        String getMapping = "/payment/get/" + id;

        return restTemplate.getForObject(PAYMENT_URL + getMapping, ResultEntity.class);
    }


}
