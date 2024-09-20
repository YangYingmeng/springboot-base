package com.zhudao.springboot.kafka._01base.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.zhudao.springboot.kafka._01base.message.BaseMessage01;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/9/4 17:02
 */
@Slf4j
@Component
public class BaseConsumer02 {

    @KafkaListener(topics = BaseMessage01.TOPIC,
            groupId = "base02-consumer-group" + BaseMessage01.TOPIC)
    public void onMsg(ConsumerRecord<Integer, String> msg) {

        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }
}
