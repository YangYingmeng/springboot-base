package com.zhudao.springboot.mapstruct.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: UserBO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 15:25
 */
@Data
@Accessors(chain = true)
public class UserBO {

    private Integer id;
    private String username;
    private String password;

    private Integer boAge;
}
