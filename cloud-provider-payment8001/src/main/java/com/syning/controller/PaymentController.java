package com.syning.controller;

import com.syning.entity.Payment;
import com.syning.entity.ResultEntity;
import com.syning.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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


    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("**********element: {}", element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost()
                    + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

}
