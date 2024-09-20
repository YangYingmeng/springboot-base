package com.zhudao.springboot.validation.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserAddDTO
 *
 * @Description: UserAddDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/12 16:33
 */
@Data
@Accessors(chain = true)
public class UserAddDTO {

    @NotEmpty(message = "账号名称不能为空")
    @Length(min = 5, max = 16, message = "账号长度为5-16")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为4-16位")
    private String password;
}
