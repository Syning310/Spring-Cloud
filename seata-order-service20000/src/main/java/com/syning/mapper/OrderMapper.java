package com.syning.mapper;

import com.syning.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface OrderMapper {

    // 1、新建订单
    void create(Order order);

    // 2、修改订单状态，从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
