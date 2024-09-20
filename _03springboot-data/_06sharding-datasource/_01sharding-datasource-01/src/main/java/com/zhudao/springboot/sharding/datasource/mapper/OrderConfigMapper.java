package com.zhudao.springboot.sharding.datasource.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.sharding.datasource.dataobject.OrderConfigDO;

/**
 * OrderConfigMapper
 *
 * @Description: OrderConfigMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 9:53
 */
@Repository
public interface OrderConfigMapper {

    OrderConfigDO selectById(@Param("id") Integer id);
}
