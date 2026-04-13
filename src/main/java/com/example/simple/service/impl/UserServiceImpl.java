package com.example.simple.service.impl;

import com.example.simple.Mapper.UserMapper;
import com.example.simple.core.Exception.CustomException;
import com.example.simple.domain.User;
import com.example.simple.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现类
 * 实现用户相关的业务逻辑
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户名和密码查询用户
     *
     * @param user 包含用户名和密码的用户对象
     * @return 查询到的用户对象
     * @throws CustomException 当用户名为空时抛出
     */
    @Override
    public User queryUser(User user) {
        // 处理自定义异常
        if (user.getName() == null) {
            throw new CustomException("用户名不能为空");
        }
        return userMapper.selectUser(user);
    }

    /**
     * 保存用户
     *
     * @param user 要保存的用户对象
     */
    @Override
    @Transactional
    public void saveUser(User user) {
        userMapper.insertUser(user);
    }

    /**
     * 保存单个用户（用于测试事务传播）
     *
     * @param user 要保存的用户对象
     */
    @Transactional
    public void saveOneUser(User user) {
        saveUser(user);
        throw new RuntimeException();
    }

    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 查询到的用户对象
     */
    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
