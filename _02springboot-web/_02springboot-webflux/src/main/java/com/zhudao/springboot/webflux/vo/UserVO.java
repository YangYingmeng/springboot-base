package com.zhudao.springboot.webflux.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: UserVO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 13:52
 */
@Data
@Accessors(chain = true)
public class UserVO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
}
