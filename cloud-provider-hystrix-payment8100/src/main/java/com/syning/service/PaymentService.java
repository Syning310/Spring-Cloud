package com.syning.service;

public interface PaymentService {

    String paymentInfo_OK(Long id);

    String paymentInfo_failed(Long id);

    String paymentCircuitBreaker(Long id);

}
