package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._05orderly.producer.OrderlyProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 11:14
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class _05OrderlyProducerTest {

    @Resource
    private OrderlyProducer orderlyProducer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            for (int id = 0; id < 4; id++) {
                orderlyProducer.syncSend(id);
                log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
                // 每次发送后等待一小段时间，以确保消息被处理,
                // 保证每次发送都是一个独立的事务, 批量发送消息需要保证路由键相同
                Thread.sleep(1000);
            }
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
