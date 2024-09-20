package com.zhudao.springboot.sharding.datasource.readwrite.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhudao.springboot.sharding.datasource.readwrite.dataobject.OrderDO;

/**
 * OrderMapper
 *
 * @Description: OrderMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 11:00
 */
@Repository
public interface OrderMapper extends BaseMapper<OrderDO> {

}
