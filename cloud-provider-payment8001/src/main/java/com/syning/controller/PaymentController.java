package com.syning.controller;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import com.syning.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class PaymentController {

    @Resource(name = "paymentService")
    private PaymentService paymentService;



    @PostMapping(value = "/payment/save")
    public ResultEntity<Integer> savePayment(@RequestBody Payment payment) {

        int ret = paymentService.save(payment);

        log.info("**********插入结果：{}", ret);

        if (ret > 0) {
            return ResultEntity.successWithData(ret);
        } else {
            return ResultEntity.failed("保存失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public ResultEntity getPaymentById(@PathVariable("id") Long id, HttpServletRequest request) {

        // 获取请求端口
        int port = request.getLocalPort();

        Payment payment = paymentService.getPaymentById(id);

        log.info("**********查询结果：{}", payment);

        if (payment != null) {
            return ResultEntity.successWithData("查询数据成功，serverPort： " + port, payment);
        } else {
            return ResultEntity.failed("查询失败");
        }
    }




}
