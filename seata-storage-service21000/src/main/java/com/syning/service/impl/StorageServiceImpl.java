package com.syning.service.impl;

import com.syning.mapper.StorageMapper;
import com.syning.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class StorageServiceImpl implements StorageService {


    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {

        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");

    }
}
