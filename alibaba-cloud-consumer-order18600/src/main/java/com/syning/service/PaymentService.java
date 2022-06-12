package com.syning.service;


import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import com.syning.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    ResultEntity<Payment> paymentSQL(@PathVariable("id") Long id);

}
