package com.zhudao.springboot.redis.dataobject;

import java.io.Serializable;
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
 * @Date: 2024/3/28 17:19
 */
@Data
@Accessors(chain = true)
@TableName(value = "users")
public class UserDO implements Serializable {

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
     * <p>
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;
}
