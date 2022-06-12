package com.syning.controller;


import com.syning.entity.ResultEntity;
import com.syning.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OpenFeignConsumerController {


    // ==========OpenFeign

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/get/{id}")
    public ResultEntity paymentSQL(@PathVariable("id") Long id) {

        ResultEntity result = paymentService.paymentSQL(id);

        return result;
    }

}
