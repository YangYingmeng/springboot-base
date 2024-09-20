package com.zhudao.springboot.dynamic.datasource.baomidou.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OrderDO
 *
 * @Description: OrderDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/22 15:11
 */
@Data
@Accessors(chain = true)
public class OrderDO {

    /**
     * 订单编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
