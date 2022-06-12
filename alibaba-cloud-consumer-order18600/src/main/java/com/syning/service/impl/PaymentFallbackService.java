package com.syning.service.impl;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import com.syning.service.PaymentService;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public ResultEntity<Payment> paymentSQL(Long id) {
        return ResultEntity.failed("服务降级, id = " + id + " class = " + PaymentFallbackService.class);
    }
}
