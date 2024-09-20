package com.zhudao.springboot.validation.dto;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserUpdateStatusDTO
 *
 * @Description: UserUpdateStatusDTO
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/13 17:20
 */
@Data
@Accessors(chain = true)
public class UserUpdateStatusDTO {

    /**
     * 分组 01 ，要求状态必须为 true
     */
    public interface Group01 {
    }

    /**
     * 状态 02 ，要求状态必须为 false
     */
    public interface Group02 {
    }

    /**
     * 状态
     */
    @AssertTrue(message = "状态必须为 true", groups = Group01.class)
    @AssertFalse(message = "状态必须为 false", groups = Group02.class)
    private Boolean status;
}
