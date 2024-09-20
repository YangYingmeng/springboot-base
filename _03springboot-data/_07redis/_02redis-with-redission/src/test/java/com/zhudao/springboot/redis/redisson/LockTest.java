package com.zhudao.springboot.redis.redisson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * LockTest
 *
 * @Description: LockTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 17:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LockTest {

    private static final String LOCK_KEY = "anylock";

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test() throws InterruptedException {
        // 启动A线程 占有锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                final RLock lock = redissonClient.getLock(LOCK_KEY);
                lock.lock(10, TimeUnit.SECONDS);
            }
        }).start();
        // sleep 1秒, 保证线程A成功持有锁
        Thread.sleep(1000L);

        // 尝试加锁, 最多等待100秒, 上锁以后10秒自动解锁
        System.out.println(String.format("准备开始获得锁时间：%s",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        final RLock lock = redissonClient.getLock(LOCK_KEY);
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            System.out.println(String.format("实际获得锁时间：%s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
        } else {
            System.out.println("加锁失败");
        }    }
}
