package com.syning.controller;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import com.syning.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class FeignOrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/consul")
    public ResultEntity<String> testConsul() {
        String ret = paymentFeignService.testConsul();
        return ResultEntity.successWithData(ret);
    }


    @GetMapping(value = "/consumer/timeout")
    public ResultEntity<String> timeout() {
        ResultEntity<String> ret = paymentFeignService.timeout();
        return ret;
    }


}
