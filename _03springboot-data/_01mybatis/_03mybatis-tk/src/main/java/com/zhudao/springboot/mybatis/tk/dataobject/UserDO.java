package com.zhudao.springboot.mybatis.tk.dataobject;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserDO
 *
 * @Description: UserDO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:55
 */
@Data
@Accessors(chain = true)
@Table(name = "users_01_mybatis")
public class UserDO {

    /**
     * 用户编号
     */
    @Id // 表示该字段为主键 ID
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    // strategy 设置使用数据库主键自增策略；generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
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

    private Integer deleted;
}
