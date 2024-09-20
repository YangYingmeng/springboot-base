package com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.constant.DBConstants;
import com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.dataobject.OrderDO;

/**
 * OrderMapper
 *
 * @Description: OrderMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/25 16:25
 */
@Repository
public interface OrderMapper {

    @DS(DBConstants.DATASOURCE_SLAVE)
    OrderDO selectById(@Param("id") Integer id);

    @DS(DBConstants.DATASOURCE_MASTER)
    int insert(OrderDO entity);
}
