package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._01base.producer.DirectBatchConsumeMsgProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * 批量消费数据测试
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/11 16:05
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class _01DirectBatchConsumerMsgProducerTest {

    @Resource
    private DirectBatchConsumeMsgProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            // 同步发送消息
            int id = (int) (System.currentTimeMillis() / 1000);
            producer.syncSend(id);

            // 故意每条消息之间，隔离 10 秒
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
            Thread.sleep(10 * 1000L);
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
