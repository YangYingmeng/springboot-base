package com.zhudao.springboot.dynamic.datasource.sharding.readwrite.mapper;

import javax.annotation.Resource;

import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.dynamic.datasource.sharding.readwrite.ShardingRWApplication;
import com.zhudao.springboot.dynamic.datasource.sharding.readwrite.dataobject.OrderDO;

/**
 * OrderMapperTest
 *
 * @Description: OrderMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingRWApplication.class)
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    // 测试从库的负载均衡: 轮询
    @Test
    public void testSelectById() {
        for (int i = 0; i < 10; i++) {
            OrderDO order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    // 测试强制访问主库
    @Test
    public void testSelectById02() {
        // HintManager 需要通过try-with-resource的机制清除, 避免污染下一次请求
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
