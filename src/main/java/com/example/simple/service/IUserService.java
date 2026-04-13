package com.example.simple.service;

import com.example.simple.domain.User;

import java.util.List;

/**
 * 用户服务接口
 * 定义用户相关的业务逻辑操作
 */
public interface IUserService {

    /**
     * 根据用户名和密码查询用户
     *
     * @param user 包含用户名和密码的用户对象
     * @return 查询到的用户对象
     */
    User queryUser(User user);

    /**
     * 保存用户
     *
     * @param user 要保存的用户对象
     */
    void saveUser(User user);

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
