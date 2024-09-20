package com.zhudao.springboot.rabbitmq._11rejecthandler.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._11rejecthandler.consumer.RejectConsumer;
import com.zhudao.springboot.rabbitmq._11rejecthandler.core.RabbitListenerErrorHandlerImpl;
import com.zhudao.springboot.rabbitmq._11rejecthandler.core.RabbitLoggingErrorHandler;
import com.zhudao.springboot.rabbitmq._11rejecthandler.message.RejectMessage;
import com.zhudao.springboot.rabbitmq._11rejecthandler.producer.RejectProducer;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/30 11:25
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "reject")
public class RejectConfig {

    @Bean
    public Queue rejectQueue() {
        return QueueBuilder.durable(RejectMessage.QUEUE)
                .build();
    }

    @Bean
    public DirectExchange rejectDirectExchange() {
        return ExchangeBuilder.directExchange(RejectMessage.EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public Binding rejectBinding() {
        return BindingBuilder.bind(rejectQueue())
                .to(rejectDirectExchange())
                .with(RejectMessage.ROUTING_KEY);
    }

    @Bean
    public RejectProducer rejectProducer() {
        return new RejectProducer();
    }

    @Bean
    public RejectConsumer rejectConsumer() {
        return new RejectConsumer();
    }


    @Bean(name = "rabbitListenerErrorHandler")
    public RabbitListenerErrorHandlerImpl rabbitListenerErrorHandler() {
        return new RabbitListenerErrorHandlerImpl();
    }

    @Bean
    public RabbitLoggingErrorHandler rabbitLoggingErrorHandler(SimpleRabbitListenerContainerFactory factory) {
        return new RabbitLoggingErrorHandler(factory);
    }
}
