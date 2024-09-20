package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._02retry.producer.RetryProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * 重试机制测试
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/17 18:27
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
@ActiveProfiles("retry")
public class _02RetryProducerTest {

    @Resource
    private RetryProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
