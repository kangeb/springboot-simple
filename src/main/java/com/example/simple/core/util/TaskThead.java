package com.example.simple.core.util;

import com.example.simple.domain.User;
import com.example.simple.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class TaskThead implements Runnable {

    @Resource
    private UserServiceImpl userServiceImpl;

    @Override
    public void run() {
        User user = new User();
        user.setName("TaskThead");
        user.setPassword("123456");
        userServiceImpl.saveOneUser(user);
        System.out.println("i am TaskThead");
    }
}
