package com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.constant.DBConstants;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.dataobject.OrderDO;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.mapper.OrderMapper;

/**
 * OrderService
 *
 * @Description: OrderService
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/25 16:26
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 加了事务, 表明该方法的所有orderMapper都是针对于master数据源的操作
     */
    @Transactional
    @DS(DBConstants.DATASOURCE_MASTER)
    public void add(OrderDO order) {
        // 这里先假模假样的读取一下，
        OrderDO exists = orderMapper.selectById(order.getId());
        System.out.println(exists);

        // 插入订单
        orderMapper.insert(order);
    }

    public OrderDO findById(Integer id) {
        return orderMapper.selectById(id);
    }
}
