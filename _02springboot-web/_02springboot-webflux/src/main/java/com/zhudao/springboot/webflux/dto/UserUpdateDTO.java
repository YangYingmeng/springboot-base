package com.zhudao.springboot.webflux.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: UserUpdateDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 13:53
 */
@Data
@Accessors(chain = true)
public class UserUpdateDTO {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
