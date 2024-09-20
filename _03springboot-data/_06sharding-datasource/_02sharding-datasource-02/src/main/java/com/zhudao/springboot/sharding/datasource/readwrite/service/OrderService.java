package com.zhudao.springboot.sharding.datasource.readwrite.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhudao.springboot.sharding.datasource.readwrite.dataobject.OrderDO;
import com.zhudao.springboot.sharding.datasource.readwrite.mapper.OrderMapper;

/**
 * OrderService
 *
 * @Description: OrderService
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 11:01
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    // 同一线程且同一数据库连接内，如有写入操作，以后的读操作均从主库读取，用于保证数据一致性。
    @Transactional
    public void add(OrderDO order) {
        // 这里先假模假样的读取一下。读取从库
        OrderDO exists = orderMapper.selectById(1);
        System.out.println(exists);

        // 插入订单
        orderMapper.insert(order);

        // 这里先假模假样的读取一下。读取主库
        exists = orderMapper.selectById(1);
        System.out.println(exists);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }
}
