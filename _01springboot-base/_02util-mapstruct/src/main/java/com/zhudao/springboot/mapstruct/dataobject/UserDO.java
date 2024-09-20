package com.zhudao.springboot.mapstruct.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: UserDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 15:26
 */
@Data
@Accessors(chain = true)
public class UserDO {

    private Integer id;
    private String username;
    private String password;

    private Integer doAge;
}
