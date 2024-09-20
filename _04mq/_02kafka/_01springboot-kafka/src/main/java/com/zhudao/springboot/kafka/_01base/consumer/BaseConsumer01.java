package com.zhudao.springboot.kafka._01base.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.zhudao.springboot.kafka._01base.message.BaseMessage01;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/9/4 17:00
 */
@Slf4j
@Component
public class BaseConsumer01 {

    @KafkaListener(topics = BaseMessage01.TOPIC,
            groupId = "base01-consumer-group" + BaseMessage01.TOPIC)
    public void onMsg(BaseMessage01 msg) {

        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }
}
