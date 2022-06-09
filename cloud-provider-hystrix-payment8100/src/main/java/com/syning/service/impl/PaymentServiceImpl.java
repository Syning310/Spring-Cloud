package com.syning.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.syning.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service(value = "paymentService")

public class PaymentServiceImpl implements PaymentService {

    // 正常访问
    @Override
    public String paymentInfo_OK(Long id) {
        return "线程池： " + Thread.currentThread().getName() +
                "  _paymentInfo_OK + id = " + id + " 哈哈哈";
    }



    // 超时
    @HystrixCommand(fallbackMethod = "timoutHandler", commandProperties = {
            // 三秒钟内是正常的逻辑
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_failed(Long id) {
//        int p = 10 / 0;    // 除0异常
        int timerNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timerNumber);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + "  _paymentInfo_failed + id = " + id + " 耗时" + timerNumber + "秒钟";
    }

    public String timoutHandler(Long id) {
        return "线程池： " + Thread.currentThread().getName()
                + "  _timoutHandler + id = " + id + "/(ㄒoㄒ)/~~";
    }




    // == 服务熔断，以上是服务降级 ==

    // 假设在 10 秒中的时间窗口期，10 次请求中有 60% 的失败率，那么这个断路器就会起作用
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("********** id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "id 不能负数，请稍后再试 /(ㄒoㄒ)/~~ id = " + id;
    }



}
