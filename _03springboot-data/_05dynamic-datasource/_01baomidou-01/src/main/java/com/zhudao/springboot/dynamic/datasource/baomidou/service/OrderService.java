package com.zhudao.springboot.dynamic.datasource.baomidou.service;

import javax.annotation.Resource;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhudao.springboot.dynamic.datasource.baomidou.constant.DBConstants;
import com.zhudao.springboot.dynamic.datasource.baomidou.dataobject.OrderDO;
import com.zhudao.springboot.dynamic.datasource.baomidou.dataobject.UserDO;
import com.zhudao.springboot.dynamic.datasource.baomidou.mapper.OrderMapper;
import com.zhudao.springboot.dynamic.datasource.baomidou.mapper.UserMapper;

/**
 * OrderService
 *
 * @Description: OrderService
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/22 15:14
 */
@Service
public class OrderService {


    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserMapper userMapper;

    private OrderService self() {
        // 通过aop上下文获取自己的代理对象
        return (OrderService) AopContext.currentProxy();
    }

    public void method01() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 加入事务后直接调用多数据源会报错
     *  1. 加了事务注解后 aop会拦截该方法创建事务(DataSourceTransactionManager), 将事务信息通过threadLocal和当前线程绑定
     *  2. 事务信息包含了connection信息, 执行userMapper时使用的是当前线程绑定的orderMapper的connection @DS注解的connection不生效
     *  3. @DS注解未放在Mapper上 事务先创建了connection
     *  4. 因为users是primary对应的DataSource
     */
    @Transactional
    public void method02() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 与02同理
     */
    public void method03() {
        // 查询订单
        self().method031();
        // 查询用户
        self().method032();
    }

    @Transactional // 报错，因为此时获取的是 primary 对应的 DataSource ，即 users 。
    public void method031() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional // 正常
    public void method032() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 使用了2个事务, 041 orders connection和线程绑定, 事务执行结束后会和当前线程解绑
     */
    public void method04() {
        // 查询订单
        self().method041();
        // 查询用户
        self().method042();
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method041() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_USERS)
    public void method042() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 正常 事务的传播特性用的是NEW, 原有05的事务会暂时挂起, 052执行结束后会将05的事务再恢复
     */
    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method05() {
        // 查询订单
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
        // 查询用户
        self().method052();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @DS(DBConstants.DATASOURCE_USERS)
    public void method052() {
        UserDO user = userMapper.selectById(1);
        System.out.println(user);
    }
}
