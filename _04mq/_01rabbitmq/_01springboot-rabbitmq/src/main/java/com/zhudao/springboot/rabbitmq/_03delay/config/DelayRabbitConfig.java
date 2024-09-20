package com.zhudao.springboot.rabbitmq._03delay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._03delay.consumer.DelayDeadConsumer;
import com.zhudao.springboot.rabbitmq._03delay.message.MessageDelay;
import com.zhudao.springboot.rabbitmq._03delay.producer.DelayProducer;

/**
 * RabbitConfig
 *
 * @Description: RabbitConfig
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:09
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "default")
public class DelayRabbitConfig {

    /**
     * 延迟消费机制
     */
    public static class DelayExchangeConfiguration {

        /**
         * 创建Queue
         */
        @Bean
        public Queue delayQueue() {
            return QueueBuilder.durable(MessageDelay.QUEUE)
                    .exclusive()
                    .autoDelete()
                    .ttl(10 * 1000) // 普通队列10s后过期, 进入死信队列, 延迟消费相当于直接消费死信队列的数据
                    .deadLetterExchange(MessageDelay.EXCHANGE)
                    .deadLetterRoutingKey(MessageDelay.DELAY_DEAD_ROUTING_KEY)
                    .build();
        }

        /**
         * 创建死信队列
         */
        @Bean
        public Queue delayDeadQueue() {
            return QueueBuilder.durable(MessageDelay.DELAY_DEAD_QUEUE)
                    .build();
        }

        /**
         * 创建Exchange
         */
        @Bean
        public DirectExchange delayExchange() {
            return ExchangeBuilder.directExchange(MessageDelay.EXCHANGE)
                    .durable(true)
                    .build();
        }

        /**
         * 创建Binding
         */
        @Bean
        public Binding delayBinding() {
            return BindingBuilder.bind(delayQueue())
                    .to(delayExchange())
                    .with(MessageDelay.ROUTING_KEY);
        }

        /**
         * 创建DeadBinding
         */
        @Bean
        public Binding delayDeadBinding() {
            return BindingBuilder.bind(delayDeadQueue())
                    .to(delayExchange())
                    .with(MessageDelay.DELAY_DEAD_ROUTING_KEY);
        }
    }


    @Bean
    public DelayDeadConsumer delayDeadConsumer() {
        return new DelayDeadConsumer();
    }
    @Bean
    public DelayProducer delayProducer() {
        return new DelayProducer();
    }
}
