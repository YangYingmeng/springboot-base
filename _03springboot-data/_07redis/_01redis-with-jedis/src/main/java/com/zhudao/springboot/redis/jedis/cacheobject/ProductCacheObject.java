package com.zhudao.springboot.redis.jedis.cacheobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ProductCacheObject
 *
 * @Description: ProductCacheObject
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/27 11:27
 */
@Data
@Accessors(chain = true)
public class ProductCacheObject {

    /**
     * 产品编号
     */
    private Integer id;
    /**
     * 产品名
     */
    private String name;
    /**
     * 产品分类编号
     */
    private Integer cid;
}
