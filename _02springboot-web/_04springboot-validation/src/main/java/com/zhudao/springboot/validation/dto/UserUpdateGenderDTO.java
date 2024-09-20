package com.zhudao.springboot.validation.dto;

import javax.validation.constraints.NotNull;

import com.zhudao.springboot.validation.constants.GenderEnum;
import com.zhudao.springboot.validation.core.validator.InEnum;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserUpdateGenderDTO
 *
 * @Description: UserUpdateGenderDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 16:34
 */
@Data
@Accessors(chain = true)
public class UserUpdateGenderDTO {

    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    private Integer id;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    @InEnum(value = GenderEnum.class, message = "性别必须是 {value}")
    private Integer gender;
}
