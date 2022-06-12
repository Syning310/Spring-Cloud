package com.syning.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.syning.entity.ResultEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,         //<-------- 自定义限流处理类
            blockHandler = "handlerException1")                     //<-----------  指定方法
    public ResultEntity customerBlockHandler()
    {
        return ResultEntity.successWithData("成功!!!");
    }


    @SentinelResource(value = "byURL")
    @GetMapping(value = "/ratelimit/byURL")
    public ResultEntity byURL() {
        return ResultEntity.successWithData("按url限流测试ok");
    }


    @SentinelResource(value = "byResource", blockHandler = "handleException")
    @GetMapping(value = "/byResource")
    public ResultEntity byResource() {
        return ResultEntity.successWithData("按资源名称限流测试ok");
    }

    public ResultEntity handleException(BlockException excep) {
        return ResultEntity.failed(excep.getClass().getCanonicalName() + "\t服务不可用");
    }


}
