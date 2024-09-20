package com.zhudao.springboot.redis.jedis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PipelineTest
 *
 * @Description: PipelineTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 14:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() {

        List<Object> results = stringRedisTemplate.executePipelined(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {

                // set 写入
                for (int i = 0; i < 3; i++) {
                    connection.set(String.format("zhudao:%d", i).getBytes(), "pipeline".getBytes());
                }

                // get
                for (int i = 0; i < 3; i++) {
                    connection.get(String.format("zhudao:%d", i).getBytes());
                }
                return null;
            }
        });
        System.out.println(results);
    }

}
