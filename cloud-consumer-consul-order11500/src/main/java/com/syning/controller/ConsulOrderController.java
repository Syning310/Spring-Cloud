package com.syning.controller;

import com.syning.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class ConsulOrderController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/getForEntity")
    public ResultEntity getForEntity() {
        ResponseEntity<String> entity
                = restTemplate.getForEntity(INVOKE_URL + "/payment/consul", String.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return ResultEntity.successWithData(entity.getBody());
        } else {
            return ResultEntity.failed("操作失败");
        }
    }




    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }

}
