package com.syning.service;

import com.syning.entity.Payment;

public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(Long id);

}
