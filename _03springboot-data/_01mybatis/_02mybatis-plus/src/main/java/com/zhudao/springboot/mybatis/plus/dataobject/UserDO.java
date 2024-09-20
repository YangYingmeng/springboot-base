package com.zhudao.springboot.mybatis.plus.dataobject;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserDO
 *
 * @Description: UserDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:02
 */
@Data
@Accessors(chain = true)
@TableName(value = "users_01_mybatis")
public class UserDO {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码（明文）
     *
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除 逻辑删除字段标识, 在yml中配置
     */
    @TableLogic
    private Integer deleted;
}
