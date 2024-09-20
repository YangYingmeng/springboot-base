package com.zhudao.springboot.dynamic.datasource.baomidou.readwrite.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OrderDO
 *
 * @Description: OrderDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/25 16:25
 */
@Data
@Accessors
public class OrderDO {

    /**
     * 订单编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;
}
