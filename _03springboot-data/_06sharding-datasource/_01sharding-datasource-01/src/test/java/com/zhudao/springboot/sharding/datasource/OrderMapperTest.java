package com.zhudao.springboot.sharding.datasource;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.sharding.datasource.dataobject.OrderDO;
import com.zhudao.springboot.sharding.datasource.mapper.OrderMapper;

/**
 * OrderMapperTest
 *
 * @Description: OrderMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 10:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDatasourceApplication.class)
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 查询不带有分片键 userId, 会全库路由, 结果再由合并引擎合并
     * 建议查询的时候带有分片键
     */
    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderDO> orders = orderMapper.selectListByUserId(1);
        System.out.println(orders.size());
    }

    @Test
    public void testInsert() {
        for (int i = 2; i < 97; i++) {
            OrderDO order = new OrderDO();
            order.setUserId(i);
            orderMapper.insert(order);
        }
    }

    @Test
    public void testPages() {
        List<OrderDO> pages = orderMapper.pages(10, 10);
        System.out.println("分页结果: " + pages);
    }
}
