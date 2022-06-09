package com.syning.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.syning.service.ProviderPaymentHystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@Slf4j
@RestController
public class HystrixOrderController {

    @Resource
    private ProviderPaymentHystrix providerPaymentHystrix;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Long id) {
        return providerPaymentHystrix.paymentInfo_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Long id) {
        return providerPaymentHystrix.paymentInfo_Timeout(id);
    }



//    @HystrixCommand(fallbackMethod = "timeOutFallbackMethod")
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/fallback/{id}")
    public String testHystrix(@PathVariable("id") Long id) {
        String result = providerPaymentHystrix.paymentInfo_Timeout(id);
        return result;
    }

    public String timeOutFallbackMethod(@PathVariable("id") Long id) {
        return "我是消费端12500，对象支付系统繁忙请10秒后再试，或者自己运行出错请在检查自己/(ㄒoㄒ)/~~";
    }



    // 全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试 /(ㄒoㄒ)/~~";
    }


}
