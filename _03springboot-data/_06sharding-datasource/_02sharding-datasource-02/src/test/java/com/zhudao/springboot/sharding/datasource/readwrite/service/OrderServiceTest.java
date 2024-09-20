package com.zhudao.springboot.sharding.datasource.readwrite.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.sharding.datasource.readwrite.ShardingDatasourceRWApplication;
import com.zhudao.springboot.sharding.datasource.readwrite.dataobject.OrderDO;

/**
 * OrderServiceTest
 *
 * @Description: OrderServiceTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDatasourceRWApplication.class)
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void testAdd() {
        OrderDO order = new OrderDO();
        order.setUserId(20);
        orderService.add(order);
    }

    @Test
    public void testFindById() {
        OrderDO order = orderService.findById(1);
        System.out.println(order);
    }
}
