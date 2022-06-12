package com.syning.controller;

import com.syning.entity.ResultEntity;
import com.syning.service.PaymentOpenfeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OpenfeignController {

    @Resource
    private PaymentOpenfeignService paymentOpenfeignService;


    @GetMapping(value = "/consument/get/{id}")
    public ResultEntity openfeignPayment(@PathVariable("id") Long id) {
        return paymentOpenfeignService.paymentSQL(id);
    }

}
