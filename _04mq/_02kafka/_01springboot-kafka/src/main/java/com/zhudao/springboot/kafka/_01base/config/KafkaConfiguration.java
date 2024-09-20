package com.zhudao.springboot.kafka._01base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/9/4 17:06
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    @Primary
    public ErrorHandler kafkaErrorHandler(KafkaTemplate<?, ?> kafkaTemplate) {

        ConsumerRecordRecoverer recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate);
        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
        return new SeekToCurrentErrorHandler(recoverer, backOff);
    }
}
