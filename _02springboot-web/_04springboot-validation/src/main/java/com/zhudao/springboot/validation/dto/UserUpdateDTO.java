package com.zhudao.springboot.validation.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserUpdateDTO
 *
 * @Description: UserUpdateDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 11:26
 */
@Data
@Accessors(chain = true)
public class UserUpdateDTO {

    /**
     * 用户编号
     */
    @NotNull(message = "{UserUpdateDTO.id.NotNull}")
    private Integer id;
}
