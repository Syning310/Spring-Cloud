package com.syning.controller;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import com.syning.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource(name = "paymentService")
    private PaymentService paymentService;


    @PostMapping(value = "/payment/save")
    public ResultEntity<Integer> savePayment(Payment payment) {

        int ret = paymentService.save(payment);

        log.info("**********插入结果：{}", ret);

        if (ret > 0) {
            return ResultEntity.successWithData(ret);
        } else {
            return ResultEntity.failed("保存失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public ResultEntity getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);

        log.info("**********查询结果：{}", payment);

        if (payment != null) {
            return ResultEntity.successWithData(payment);
        } else {
            return ResultEntity.failed("查询失败");
        }
    }




}
