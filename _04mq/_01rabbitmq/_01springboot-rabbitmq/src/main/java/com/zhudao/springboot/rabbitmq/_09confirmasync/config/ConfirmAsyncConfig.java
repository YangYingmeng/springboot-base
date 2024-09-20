package com.zhudao.springboot.rabbitmq._09confirmasync.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._09confirmasync.consumer.ConfirmAsyncConsumer;
import com.zhudao.springboot.rabbitmq._09confirmasync.core.RabbitProducerConfirmCallback;
import com.zhudao.springboot.rabbitmq._09confirmasync.core.RabbitProducerReturnCallback;
import com.zhudao.springboot.rabbitmq._09confirmasync.message.ConfirmAsyncMessage;
import com.zhudao.springboot.rabbitmq._09confirmasync.producer.ConfirmAsyncProducer;


/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:08
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "confirm")
public class ConfirmAsyncConfig {

    public static class ConfirmAsyncDirectExchangeConfiguration {

        @Bean
        public Queue confirmAsyncQueue() {
            return QueueBuilder.durable(ConfirmAsyncMessage.QUEUE)
                    .build();
        }

        @Bean
        public DirectExchange confirmAsyncExchange() {
            return ExchangeBuilder.directExchange(ConfirmAsyncMessage.EXCHANGE)
                    .durable(true)
                    .build();
        }

        @Bean
        public Binding confirmAsyncBinding() {
            return BindingBuilder.bind(confirmAsyncQueue())
                    .to(confirmAsyncExchange())
                    .with(ConfirmAsyncMessage.ROUTING_KEY);
        }
    }


    @Bean
    public ConfirmAsyncConsumer confirmAsyncConsumer() {
        return new ConfirmAsyncConsumer();
    }

    @Bean
    public ConfirmAsyncProducer confirmAsyncProducer() {
        return new ConfirmAsyncProducer();
    }

    @Bean
    public RabbitProducerConfirmCallback rabbitProducerConfirmCallback(RabbitTemplate rabbitTemplate) {
        return new RabbitProducerConfirmCallback(rabbitTemplate);
    }

    @Bean
    public RabbitProducerReturnCallback rabbitProducerReturnCallback(RabbitTemplate rabbitTemplate) {
        return new RabbitProducerReturnCallback(rabbitTemplate);
    }
}
