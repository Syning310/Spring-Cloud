package com.syning.service;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentOpenfeignService {
    @Override
    public ResultEntity<Payment> paymentSQL(Long id) {
        return ResultEntity.failed("服务降级 class = " + PaymentFallbackService.class);
    }
}
