package com.example.simple.Mapper;

import com.example.simple.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据访问接口
 * 使用MyBatis XML配置方式实现
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户
     *
     * @param user 包含用户名和密码的用户对象
     * @return 查询到的用户对象
     */
    User selectUser(User user);

    /**
     * 插入新用户
     *
     * @param user 要插入的用户对象
     */
    void insertUser(User user);

    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 查询到的用户对象
     */
    User queryByName(String name);

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<User> queryAll();
}
