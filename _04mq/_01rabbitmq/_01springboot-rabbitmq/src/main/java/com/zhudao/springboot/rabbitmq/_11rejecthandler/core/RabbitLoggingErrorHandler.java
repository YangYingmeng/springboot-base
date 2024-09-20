package com.zhudao.springboot.rabbitmq._11rejecthandler.core;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.util.ErrorHandler;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/30 13:40
 */
@Slf4j
public class RabbitLoggingErrorHandler implements ErrorHandler {

    public RabbitLoggingErrorHandler(SimpleRabbitListenerContainerFactory factory) {
        factory.setErrorHandler(this);
    }

    @Override
    public void handleError(Throwable t) {
        log.error("[handleError][发生异常]]", t);
    }
}
