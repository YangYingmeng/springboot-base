package com.zhudao.springboot.dynamic.datasource.sharding.readwrite.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhudao.springboot.dynamic.datasource.sharding.readwrite.dataobject.OrderDO;
import com.zhudao.springboot.dynamic.datasource.sharding.readwrite.mapper.OrderMapper;

/**
 * OrderService
 *
 * @Description: OrderService
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 16:53
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Transactional
    public void add(OrderDO order) {
        // 1.1 读取从库
        OrderDO exists = orderMapper.selectById(1);
        System.out.println(exists);

        // 1.2 插入主库
        orderMapper.insert(order);

        // 1.3 读取主库, sharding-jdbc约定, 同一线程中如果有插入操作, 后续读取操作皆走主库 保证数据的一致性
        exists = orderMapper.selectById(1);
        System.out.println(exists);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }
}
