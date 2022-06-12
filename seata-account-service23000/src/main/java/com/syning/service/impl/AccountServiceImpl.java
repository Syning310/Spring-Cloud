package com.syning.service.impl;

import com.syning.mapper.AccountMapper;
import com.syning.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");

        // 模拟超时异常，全局事务回滚
        try {
            TimeUnit.SECONDS.sleep(20);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        accountMapper.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }


}
