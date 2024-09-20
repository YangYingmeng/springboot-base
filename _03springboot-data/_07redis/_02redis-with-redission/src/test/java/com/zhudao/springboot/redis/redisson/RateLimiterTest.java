package com.zhudao.springboot.redis.redisson;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RateLimiterTest
 *
 * @Description: RateLimiterTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 17:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RateLimiterTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test() throws InterruptedException {
        // 创建RRateLimiter对象
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("myRateLimiter");
        // 初始化: 最大流速 = 每 1 秒产生2个令牌
        rateLimiter.trySetRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("%s：获得锁结果(%s)", simpleDateFormat.format(new Date()),
                    rateLimiter.tryAcquire()));
            Thread.sleep(250L);
        }
    }
}
