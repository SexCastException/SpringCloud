package com.huazai.springcloud.stream.rabbitmq.provider.service.impl;

import com.huazai.springcloud.stream.rabbitmq.provider.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author pyh
 * @date 2020/8/21 22:24
 */
@Slf4j
@EnableBinding(Source.class)    // 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        log.info("序列号：" + serial);
        output.send(MessageBuilder.withPayload(serial).build());
        return serial;
    }
}
