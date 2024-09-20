package com.zhudao.springboot.kafka._01base.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/9/4 16:49
 */
@Data
@Accessors(chain = true)
public class BaseMessage01 {

    public static final String TOPIC = "BaseMessage_01";

    private Integer id;

    @Override
    public String toString() {
        return "BaseMessage01{" +
                "id=" + id +
                '}';
    }
}
