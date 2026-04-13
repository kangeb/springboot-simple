package com.example.simple.core.util;

import com.example.simple.domain.User;
import com.example.simple.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 任务线程类
 * 用于测试事务与线程的结合
 */
@Component
public class TaskThead implements Runnable {

    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 线程执行方法
     * 在线程中保存用户数据
     */
    @Override
    public void run() {
        User user = new User();
        user.setName("TaskThead");
        user.setPassword("123456");
        userServiceImpl.saveOneUser(user);
        System.out.println("i am TaskThead");
    }
}
