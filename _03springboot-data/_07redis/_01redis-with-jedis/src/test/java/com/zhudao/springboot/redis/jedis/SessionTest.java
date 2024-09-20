package com.zhudao.springboot.redis.jedis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SessionTest
 *
 * @Description: SessionTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 15:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {

        String result = stringRedisTemplate.execute(new SessionCallback<String>() {

            @Override
            public String execute(RedisOperations operations) throws DataAccessException {

                for (int i = 0; i < 100; i++) {
                    operations.opsForValue()
                            .set(String.format("zhudao:%d", i), "session");
                }
                return (String) operations.opsForValue().get(String.format("yunai:%d", 0));
            }
        });
        System.out.println(result);
    }
}
