package com.zhudao.springboot.sharding.datasource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.sharding.datasource.dataobject.OrderDO;

/**
 * OrderMapper
 *
 * @Description: OrderMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 9:53
 */
@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);

    void insert(OrderDO order);

    List<OrderDO> pages(@Param("limit") int limit,
                        @Param("offset") int offset);

}
