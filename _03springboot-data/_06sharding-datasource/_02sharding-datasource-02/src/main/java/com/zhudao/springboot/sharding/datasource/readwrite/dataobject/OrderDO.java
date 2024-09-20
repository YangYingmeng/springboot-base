package com.zhudao.springboot.sharding.datasource.readwrite.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OrderDO
 *
 * @Description: OrderDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 10:57
 */
@Data
@Accessors(chain = true)
@TableName(value = "orders")
public class OrderDO {

    /**
     * 订单编号
     */
    private Long id;
    /**
     * 用户编号
     */
    private Integer userId;
}
