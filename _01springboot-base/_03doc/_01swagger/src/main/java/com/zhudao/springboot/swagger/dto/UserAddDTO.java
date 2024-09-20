package com.zhudao.springboot.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: UserAddDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 16:07
 */
@ApiModel("添加用户 DTO")
@Data
@Accessors(chain = true)
public class UserAddDTO {

    @ApiModelProperty(value = "姓名", required = true, example = "逐道")
    private String name;
    @ApiModelProperty(value = "密码", required = true, example = "zhudao123")
    private String password;
}
