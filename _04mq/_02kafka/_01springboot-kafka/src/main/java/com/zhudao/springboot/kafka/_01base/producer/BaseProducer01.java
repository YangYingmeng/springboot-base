package com.zhudao.springboot.kafka._01base.producer;

import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.zhudao.springboot.kafka._01base.message.BaseMessage01;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/9/4 16:55
 */
@Component
public class BaseProducer01 {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {

        BaseMessage01 msg = new BaseMessage01().setId(id);
        // 同步发送消息
        return kafkaTemplate.send(BaseMessage01.TOPIC, msg).get();
    }

    public ListenableFuture<SendResult<Object, Object>> asyncSend(Integer id) {

        BaseMessage01 msg = new BaseMessage01().setId(id);
        // 异步发送消息
        return kafkaTemplate.send(BaseMessage01.TOPIC, msg);
    }
}
