package com.zhudao.springboot.jdbc.dao;

import java.sql.Types;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.zhudao.springboot.jdbc.dataobject.UserDO;

/**
 * UserDao
 *
 * @Description: UserDao
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2024/3/15 15:56
 */
@Repository
public class UserDao {

    /**
     * 声明 INSERT 操作的 PreparedStatementCreatorFactory 对象
     */
    private static final PreparedStatementCreatorFactory INSERT_PREPARED_STATEMENT_CREATOR_FACTORY =
            new PreparedStatementCreatorFactory("INSERT INTO users(username, password, create_time, deleted) VALUES (?, ?, ?, ?)");

    static {
        // 设置返回主键
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.setReturnGeneratedKeys(true);
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.setGeneratedKeysColumnNames("id");
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.VARCHAR));
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.VARCHAR));
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.TIMESTAMP));
        INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.addParameter(new SqlParameter(Types.INTEGER));
    }

    @Resource
    private JdbcTemplate template;


    /**
     * 使用 PreparedStatementCreator 实现插入数据
     *
     * @param entity 实体
     * @return 影响行数
     */
    public int insert(UserDO entity) {
        // 创建 keyHolder对象, 设置返回的主键 ID
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        // 执行插入操作
        int updateCounts = template.update(INSERT_PREPARED_STATEMENT_CREATOR_FACTORY.newPreparedStatementCreator(
                Arrays.asList(entity.getUsername(), entity.getPassword(), entity.getCreateTime(), entity.getDeleted())
        ), keyHolder);
        // 将主键设置到entity中
        if (keyHolder.getKey() != null) {
            entity.setId(keyHolder.getKey().intValue());
        }
        // 返回影响的行数
        return updateCounts;
    }

    /**
     * 使用 SimpleJdbcInsert 实现插入数据
     *
     * @param entity 实体
     * @return 影响行数
     */
    public int simpleJdbcInsert(UserDO entity) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(template);
        simpleJdbcInsert.setTableName("users");
        simpleJdbcInsert.setColumnNames(Arrays.asList("username", "password", "create_time"));
        simpleJdbcInsert.setGeneratedKeyName("id");
        // 拼接参数
        Map<String, Object> params = new HashMap<>();
        params.put("username", entity.getUsername());
        params.put("password", entity.getPassword());
        params.put("create_time", entity.getCreateTime());
        // 插入操作
        Number id = simpleJdbcInsert.executeAndReturnKey(params);
        entity.setId(id.intValue());
        // 返回影响行数
        return 1;
    }

    public int updateById(UserDO entity) {
        return template.update("UPDATE users SET password = ? WHERE id = ?",
                entity.getPassword(),
                entity.getId());
    }

    public int deleteById(Integer id) {
        return template.update("DELETE FROM users WHERE id = ?", id);
    }

    public UserDO selectById(Integer id) {
        return template.queryForObject("SELECT id, username, password, create_time FROM users WHERE id = ?",
                new BeanPropertyRowMapper<>(UserDO.class), // 结果转换成对应的对象
                id);
    }

    public List<UserDO> selectByIds(List<Integer> ids) {
        // 创建 NamedParameterJdbcTemplate 对象
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(template);
        // 拼接参数
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        // 执行查询
        return namedParameterJdbcTemplate.query(
                "SELECT id, username, password, create_time FROM users WHERE id IN (:ids)", // 使用 :ids 作为占位服务
                params,
                new BeanPropertyRowMapper<>(UserDO.class) // 结果转换成对应的对象
        );
    }
}
