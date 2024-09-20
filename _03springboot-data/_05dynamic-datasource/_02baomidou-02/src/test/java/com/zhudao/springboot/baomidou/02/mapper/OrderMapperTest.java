package com.zhudao.springboot.baomidou.mapper;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.BaoMiDouApplication;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.dataobject.OrderDO;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.mapper.OrderMapper;

/**
 * OrderMapperTest
 *
 * @Description: OrderMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/25 17:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaoMiDouApplication.class)
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        for (int i = 0; i < 10; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() {
        OrderDO order = new OrderDO();
        order.setUserId(10);
        orderMapper.insert(order);
    }
}
