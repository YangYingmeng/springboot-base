package com.zhudao.springboot.dynamic.datasource.sharding.readwrite.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.dynamic.datasource.sharding.readwrite.dataobject.OrderDO;

/**
 * OrderMapper
 *
 * @Description: OrderMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/26 16:52
 */
@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

    int insert(OrderDO entity);
}
