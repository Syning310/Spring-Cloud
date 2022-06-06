package com.syning.mapper;

import com.syning.entity.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentMapper {

    int save(@Param("payment") Payment payment);

    Payment getPaymentById(@Param("id") Long id);


}
