package com.zhudao.springboot.rabbitmq._10messageconverter.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhudao.springboot.rabbitmq._10messageconverter.consumer.ConverterConsumer;
import com.zhudao.springboot.rabbitmq._10messageconverter.message.ConverterMessage;
import com.zhudao.springboot.rabbitmq._10messageconverter.producer.ConverterProducer;

/**
 * 增加json消息转换器
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/29 14:53
 */
@Configuration
@ConditionalOnProperty(name = "yml.prefix", havingValue = "converter")
public class ConverterRabbitConfig {

    @Bean
    public Queue converterQueue() {
        return QueueBuilder.durable(ConverterMessage.QUEUE)
                .build();
    }

    @Bean
    public DirectExchange converterExchange() {
        return ExchangeBuilder.directExchange(ConverterMessage.EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public Binding converterBinding() {
        return BindingBuilder.bind(converterQueue())
                .to(converterExchange())
                .with(ConverterMessage.ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ConverterProducer converterProducer() {
        return new ConverterProducer();
    }

    @Bean
    public ConverterConsumer converterConsumer() {
        return new ConverterConsumer();
    }

}
