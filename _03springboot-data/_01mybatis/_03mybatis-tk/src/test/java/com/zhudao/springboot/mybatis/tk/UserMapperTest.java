package com.zhudao.springboot.mybatis.tk;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.mybatis.tk.dataobject.UserDO;
import com.zhudao.springboot.mybatis.tk.mapper.UserMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisTkApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date());
        userMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO().setId(1)
                .setPassword("wobucai");
        userMapper.updateByPrimaryKey(updateUser);
    }

    // 更多使用，可以参考 https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
    @Test
    public void testDeleteById() {
        userMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void testSelectById() {
        userMapper.selectByPrimaryKey(1);
    }

}
