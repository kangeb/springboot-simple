package com.example.simple.Mapper;

import com.example.simple.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据访问层接口
 * 提供用户相关的数据库操作方法
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     * @param user 用户对象，包含用户名和密码
     * @return 查询到的用户对象，如果不存在则返回null
     */
    User selectUser(User user);

    /**
     * 新增用户
     * @param user 用户对象
     */
    void insertUser(User user);

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return 查询到的用户对象，如果不存在则返回null
     */
    User queryByName(String name);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> queryAll();
}
