package com.zhudao.springboot.sharding.datasource;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.sharding.datasource.dataobject.OrderConfigDO;
import com.zhudao.springboot.sharding.datasource.mapper.OrderConfigMapper;

/**
 * OrderConfigMapperTest
 *
 * @Description: OrderConfigMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 9:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingDatasourceApplication.class)
public class OrderConfigMapperTest {

    @Resource
    private OrderConfigMapper orderConfigMapper;

    @Test
    public void testSelectById() {

        OrderConfigDO orderConfig = orderConfigMapper.selectById(1);
        System.out.println(orderConfig);
    }
}
