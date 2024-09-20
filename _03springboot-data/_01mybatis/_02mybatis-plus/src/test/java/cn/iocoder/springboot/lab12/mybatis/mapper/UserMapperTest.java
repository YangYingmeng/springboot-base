package cn.iocoder.springboot.lab12.mybatis.mapper;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhudao.springboot.mybatis.plus.MybatisPlusApplication;
import com.zhudao.springboot.mybatis.plus.dataobject.UserDO;
import com.zhudao.springboot.mybatis.plus.mapper.UserMapper;

/**
 * UserMapperTest
 *
 * @Description: UserMapperTest
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/14 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                                  .setPassword("123")
                                  .setCreateTime(new Date())
                                  .setDeleted(0);
        userMapper.insert(user);
    }
}
