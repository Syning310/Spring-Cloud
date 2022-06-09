package com.syning.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "provider-hystrix-payment",
        fallback = PaymentFallbackService.class)
@Component
public interface ProviderPaymentHystrix {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Long id);

}
