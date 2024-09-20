package com.zhudao.springboot.dynamic.datasource.baomidou.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhudao.springboot.dynamic.datasource.baomidou.constant.DBConstants;
import com.zhudao.springboot.dynamic.datasource.baomidou.dataobject.OrderDO;


/**
 * OrderMapper
 *
 * @Description: OrderMapper
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/22 15:13
 */
@Repository
@DS(DBConstants.DATASOURCE_ORDERS)
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);
}
