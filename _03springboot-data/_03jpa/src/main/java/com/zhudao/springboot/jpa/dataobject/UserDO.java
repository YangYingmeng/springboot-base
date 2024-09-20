package com.zhudao.springboot.jpa.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户 DO
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "users_01_mybatis")
public class UserDO {

    /**
     * 用户编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  // strategy 设置使用数据库主键自增策略；
            generator = "JDBC") // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer id;
    /**
     * 账号
     */
    @Column(nullable = false)
    private String username;
    /**
     * 密码（明文）
     *
     * ps：生产环境下，千万不要明文噢
     */
    @Column(nullable = false)
    private String password;
    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    private Integer deleted;
}
