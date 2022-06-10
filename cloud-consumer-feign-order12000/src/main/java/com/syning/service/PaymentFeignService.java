package com.syning.service;


import com.syning.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(value = "consul-provider-payment")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/payment/zipkin")
    String paymentZipkin();

    @GetMapping(value = "/payment/consul")
    String testConsul();

    @GetMapping(value = "/timeout")
    ResultEntity<String> timeout();

}
