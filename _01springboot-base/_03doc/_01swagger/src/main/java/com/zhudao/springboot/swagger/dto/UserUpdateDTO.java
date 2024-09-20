package com.zhudao.springboot.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: UserUpdateDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 16:07
 */
@ApiModel("更新用户 DTO")
@Data
@Accessors(chain = true)
public class UserUpdateDTO {

    @ApiModelProperty(value = "用户编号", required = true, example = "1")
    private Long id;
    @ApiModelProperty(value = "姓名", required = true, example = "逐道")
    private String name;
    @ApiModelProperty(value = "密码", required = true, example = "zhudao123")
    private String password;
}
