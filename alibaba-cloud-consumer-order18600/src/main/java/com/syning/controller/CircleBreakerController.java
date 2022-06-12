package com.syning.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {


    public static String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

//    @SentinelResource(value = "fallback")           // 1、没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")           // 2、fallback只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")           // 3、fallback只负责blockHandler控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")  // 4、fallback和blockHandler都配置
    @RequestMapping("/consumer/fallback/{id}")
    public ResultEntity fallback(@PathVariable("id") Long id) {
        String api = SERVICE_URL + "/paymentSQL/" + id;
        ResultEntity result = restTemplate.getForObject(api, ResultEntity.class);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }

    //本例是blockHandler
    public ResultEntity blockHandler(@PathVariable  Long id, BlockException blockException) {
        return ResultEntity.failed("blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage());
    }


    // 本例是fallback
    public ResultEntity handlerFallback(@PathVariable("id") Long id, Throwable e) {
        return ResultEntity.failed("兜底异常handlerFallback，exception内容 = " + e.getMessage() + "\t异常类型 = " + e.getClass());
    }


}
