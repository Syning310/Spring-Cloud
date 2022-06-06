package com.syning.service.impl;

import com.syning.entity.Payment;
import com.syning.mapper.PaymentMapper;
import com.syning.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource(name = "paymentMapper")
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
