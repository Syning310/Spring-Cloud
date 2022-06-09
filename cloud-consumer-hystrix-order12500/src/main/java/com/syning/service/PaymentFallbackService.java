package com.syning.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements ProviderPaymentHystrix {
    @Override
    public String paymentInfo_Ok(Long id) {
        return "----------PaymentFallbackService _paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_Timeout(Long id) {
        return "----------PaymentFallbackService _paymentInfo_Timeout";
    }
}
