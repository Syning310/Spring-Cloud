package com.syning.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {

        log.info("{}\t....testA", Thread.currentThread().getName());
        return "---------->testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "---------->testB";
    }



    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
            log.info("RT");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "---------->testD";
    }


    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    @GetMapping("/testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int i = 10 / 0;
        return "---------->testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {

        return "---------->deal_testHotKey";    // sentinel系统的默认提示：Blocked by Sentinel(flow limiting)
    }



}
