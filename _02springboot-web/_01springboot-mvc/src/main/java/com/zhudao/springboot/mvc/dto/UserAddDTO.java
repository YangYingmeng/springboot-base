package com.zhudao.springboot.mvc.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserAddDTO
 *
 * @Description: UserAddDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/26 9:41
 */
@Data
@Accessors(chain = true)
public class UserAddDTO {

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
