package com.zhudao.springboot.rabbitmq._04model.message;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 集群消费消息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/7/22 9:37
 */
@Data
@Accessors(chain = true)
public class ClusteringMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";

    /**
     * 编号
     */
    private Integer id;

    @Override
    public String toString() {
        return "ClusteringtMessage{" +
                "id=" + id +
                '}';
    }
}
