package com.zhudao.springboot.dynamic.datasource.sharding.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.dynamic.datasource.sharding.ShardingApplication;
import com.zhudao.springboot.dynamic.datasource.sharding.dataobject.OrderDO;

/**
 * OrderMapperTest
 *
 * @Description: OrderMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 15:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }
}
