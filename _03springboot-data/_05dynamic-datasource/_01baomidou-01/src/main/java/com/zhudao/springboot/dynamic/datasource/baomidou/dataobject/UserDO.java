package com.zhudao.springboot.dynamic.datasource.baomidou.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserDO
 *
 * @Description: UserDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/22 15:12
 */
@Data
@Accessors(chain = true)
public class UserDO {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
