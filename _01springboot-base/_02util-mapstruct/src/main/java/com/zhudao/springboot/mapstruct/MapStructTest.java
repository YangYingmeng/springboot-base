package com.zhudao.springboot.mapstruct;

import com.zhudao.springboot.mapstruct.bo.UserBO;
import com.zhudao.springboot.mapstruct.convert.UserConvert;
import com.zhudao.springboot.mapstruct.dataobject.UserDO;

/**
 * @Description: MapStructTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/2/23 15:29
 */
public class MapStructTest {

    public static void main(String[] args) {
        UserDO userDO = new UserDO()
                .setId(1).setUsername("zhudao").setPassword("zhudao").setDoAge(1);
        // 进行转换
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO.toString());
    }
}
