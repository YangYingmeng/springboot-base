package com.zhudao.springboot.rabbitmq._03delay.producer;

import javax.annotation.Resource;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.zhudao.springboot.rabbitmq._03delay.message.MessageDelay;

/**
 * 延迟 生产者
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:23
 */
public class DelayProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id, Integer delay) {
        // 创建 Demo07Message 消息
        MessageDelay message = new MessageDelay();
        message.setId(id);
        // 同步发送消息
        rabbitTemplate.convertAndSend(MessageDelay.EXCHANGE, MessageDelay.ROUTING_KEY, message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置消息的 TTL 过期时间
                if (delay != null && delay > 0) {
                    // Spring-AMQP API 设计有问题，所以传入了 String = =
                    message.getMessageProperties().setExpiration(String.valueOf(delay));
                }
                return message;
            }
        });
    }
}
