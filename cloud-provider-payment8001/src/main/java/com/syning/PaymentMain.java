package com.syning;

import com.syning.mapper.PaymentMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@MapperScan("com.syning.mapper")
@SpringBootApplication
public class PaymentMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PaymentMain.class, args);

//        String[] names = context.getBeanNamesForType(PaymentMapper.class);
//
//        for (String name : names) {
//            System.out.println(name);     // paymentMapper
//        }

    }
}
