package com.syning.service;


import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentOpenfeignService {

    @GetMapping(value = "/paymentSQL/{id}")
    ResultEntity<Payment> paymentSQL(@PathVariable("id") Long id);

}
