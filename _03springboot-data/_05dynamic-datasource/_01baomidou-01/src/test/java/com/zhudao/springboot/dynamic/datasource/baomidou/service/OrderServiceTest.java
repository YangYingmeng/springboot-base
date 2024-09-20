package com.zhudao.springboot.dynamic.datasource.baomidou.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.dynamic.datasource.baomidou.BaoMiDouApplication;

/**
 * OrderServiceTest
 *
 * @Description: OrderServiceTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/25 15:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaoMiDouApplication.class)
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
