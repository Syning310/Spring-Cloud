package com.syning.controller;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.syning.entity.ResultEntity;

public class CustomerBlockHandler {
    public static ResultEntity handlerException1(BlockException exception) {
        return ResultEntity.failed("自定义，global handlerException  ----->  1");
    }

    public static ResultEntity handlerException2(BlockException exception) {
        return ResultEntity.failed("自定义，global handlerException  ----->  2");
    }
}
