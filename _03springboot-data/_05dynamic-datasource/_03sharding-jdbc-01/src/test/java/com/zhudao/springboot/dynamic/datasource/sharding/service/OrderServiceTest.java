package com.zhudao.springboot.dynamic.datasource.sharding.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.dynamic.datasource.sharding.ShardingApplication;

/**
 * OrderServiceTest
 *
 * @Description: OrderServiceTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 15:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void testMethod01() {
        orderService.method01();
    }

    @Test
    public void testMethod02() {
        orderService.method02();
    }

    @Test
    public void testMethod03() {
        orderService.method03();
    }

    @Test
    public void testMethod04() {
        orderService.method04();
    }

    @Test
    public void testMethod05() {
        orderService.method05();
    }
}
