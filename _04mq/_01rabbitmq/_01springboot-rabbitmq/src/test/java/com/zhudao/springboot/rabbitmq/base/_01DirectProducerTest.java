package com.zhudao.springboot.rabbitmq.base;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.zhudao.springboot.rabbitmq.BaseApplication;
import com.zhudao.springboot.rabbitmq._01base.producer.DirectProducer;

import lombok.extern.slf4j.Slf4j;

/**
 * DirectProducerTest
 *
 * @Description: DirectProducerTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/29 10:41
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class _01DirectProducerTest {

    @Resource
    private DirectProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void tesSyncSendDefault() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSendDefault(id);
        log.info("[tesSyncSendDefault][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }


    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);

        producer.asyncSend(id).addCallback(new ListenableFutureCallback<Void>() {

            @Override
            public void onFailure(Throwable e) {
                log.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, e);
            }

            @Override
            public void onSuccess(Void aVoid) {
                log.info("[testASyncSend][发送编号：[{}] 发送成功，发送成功]", id);
            }

        });
        log.info("[testASyncSend][发送编号：[{}] 调用完成]", id);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
