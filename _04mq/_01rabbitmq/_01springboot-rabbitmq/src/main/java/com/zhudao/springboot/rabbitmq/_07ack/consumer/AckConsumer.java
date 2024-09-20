package com.zhudao.springboot.rabbitmq._07ack.consumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;

import com.rabbitmq.client.Channel;
import com.zhudao.springboot.rabbitmq._07ack.message.AckMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/24 15:43
 */
@Slf4j
@RabbitListener(queues = AckMessage.QUEUE)
public class AckConsumer {

    @RabbitHandler
    public void onMessage(AckMessage message, Channel channel,
                          @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        if (message.getId() % 2 == 1) {
            // ack 确认消息
            // 第二个参数 multiple ，用于批量确认消息，为了减少网络流量，手动确认可以被批处。
            // 1. 当 multiple 为 true 时，则可以一次性确认 deliveryTag 小于等于传入值的所有消息
            // 2. 当 multiple 为 false 时，则只确认当前 deliveryTag 对应的消息
            channel.basicAck(deliveryTag, false);
        }
    }
}
