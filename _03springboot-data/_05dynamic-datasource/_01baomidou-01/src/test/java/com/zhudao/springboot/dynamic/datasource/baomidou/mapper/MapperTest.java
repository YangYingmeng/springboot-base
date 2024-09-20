package com.zhudao.springboot.dynamic.datasource.baomidou.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.dynamic.datasource.baomidou.BaoMiDouApplication;
import com.zhudao.springboot.dynamic.datasource.baomidou.dataobject.OrderDO;
import com.zhudao.springboot.dynamic.datasource.baomidou.dataobject.UserDO;

/**
 * MapperTest
 *
 * @Description: MapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/25 15:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaoMiDouApplication.class)
public class MapperTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testUM() {
        UserDO userDO = userMapper.selectById(1);
        System.out.println(userDO);
    }

    @Test
    public void testOM() {
        OrderDO orderDO = orderMapper.selectById(1);
        System.out.println(orderDO);
    }
}
