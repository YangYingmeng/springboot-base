package com.zhudao.springboot.redis.jedis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.redis.jedis.cacheobject.UserCacheObject;
import com.zhudao.springboot.redis.jedis.service.UserService02;

/**
 * UserService02Test
 *
 * @Description: UserService02Test
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 15:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserService02Test {

    @Resource
    private UserService02 userService02;

    @Test
    public void test() {
        UserCacheObject user = new UserCacheObject().setId(999)
                .setGender(11)
                .setName("zhudao");
        userService02.set(user.getId(), user);
        System.out.println(userService02.get(user.getId()));
    }

}
