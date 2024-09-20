package com.zhudao.springboot.sharding.datasource.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * OrderConfigDO
 *
 * @Description: OrderConfigDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 9:51
 */
@Data
@Accessors(chain = true)
public class OrderConfigDO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 支付超时时间
     * 单位：分钟
     */
    private Integer payTimeout;

}
