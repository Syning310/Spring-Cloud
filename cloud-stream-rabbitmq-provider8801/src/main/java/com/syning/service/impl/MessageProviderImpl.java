package com.syning.service.impl;

import com.syning.service.IMessageProvider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();

        output.send(MessageBuilder.withPayload(serial).build());

        log.info("******serial = {}", serial);

        return null;
    }
}
