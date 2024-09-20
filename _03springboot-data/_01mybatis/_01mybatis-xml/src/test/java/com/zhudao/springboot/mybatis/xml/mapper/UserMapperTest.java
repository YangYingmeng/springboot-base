package com.zhudao.springboot.mybatis.xml.mapper;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.mybatis.xml.MybatisXmlApplication;
import com.zhudao.springboot.mybatis.xml.dataobject.UserDO;

import javafx.application.Application;

/**
 * UserMapperTest
 *
 * @Description: UserMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 13:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisXmlApplication.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO userDO = new UserDO()
                .setUsername("1")
                .setPassword("123")
                .setCreateTime(new Date());
        userMapper.insert(userDO);
    }
}
