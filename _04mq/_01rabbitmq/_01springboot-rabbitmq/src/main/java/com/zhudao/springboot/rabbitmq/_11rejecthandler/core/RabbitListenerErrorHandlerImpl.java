package com.zhudao.springboot.rabbitmq._11rejecthandler.core;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/30 13:43
 */
@Slf4j
public class RabbitListenerErrorHandlerImpl implements RabbitListenerErrorHandler {

    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message,
                              ListenerExecutionFailedException exception) throws Exception {
        // 打印异常日志
        log.error("[handleError][amqpMessage:[{}] message:[{}]]", amqpMessage, message, exception);

        // 直接继续抛出异常
        throw exception;
    }
}
