package com.zhudao.springboot.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserVO
 *
 * @Description: UserVO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 16:15
 */
@ApiModel("用户 VO")
@Data
@Accessors(chain = true)
public class UserVO {

    @ApiModelProperty(value = "用户编号", required = true, example = "1")
    private Long id;
    @ApiModelProperty(value = "用户姓名", required = true, example = "逐道")
    private String username;
}
