package com.zhudao.springboot.sharding.datasource.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OrderDO
 *
 * @Description: OrderDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 9:52
 */
@Data
@Accessors(chain = true)
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
