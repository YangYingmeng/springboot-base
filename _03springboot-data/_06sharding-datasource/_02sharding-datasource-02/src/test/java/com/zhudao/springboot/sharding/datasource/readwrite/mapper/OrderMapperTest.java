package com.zhudao.springboot.sharding.datasource.readwrite.mapper;

import javax.annotation.Resource;

import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.sharding.datasource.readwrite.ShardingDatasourceRWApplication;
import com.zhudao.springboot.sharding.datasource.readwrite.dataobject.OrderDO;

/**
 * OrderMapperTest
 *
 * @Description: OrderMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 11:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDatasourceRWApplication.class)
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() { // 测试从库的负载均衡
        for (int i = 0; i < 2; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testSelectById02() { // 测试强制访问主库
        try (HintManager hintManager = HintManager.getInstance()) {
            // 设置强制访问主库
            hintManager.setMasterRouteOnly();
            // 执行查询
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() { // 插入
        OrderDO order = new OrderDO();
        order.setUserId(10);
        orderMapper.insert(order);
    }
}
