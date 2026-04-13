package com.example.simple.service.impl;

import com.example.simple.core.util.TaskThead;
import com.example.simple.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 事务测试服务类
 * 用于测试事务传播行为和线程事务
 */
@Service()
public class TransactionService {

    @Resource
    private UserServiceImpl userServiceImpl;

    @Resource
    private TaskThead taskThead;

    /**
     * 测试事务1
     * 测试事务与线程的结合
     *
     * @throws InterruptedException 中断异常
     */
    @Transactional
    public void saveTest() throws InterruptedException {
        User user = new User();
        user.setName("oneTest");
        user.setPassword("123456");
        userServiceImpl.saveUser(user);
        Thread t = new Thread(taskThead);
        t.start();
        t.join();
        System.out.println("i am main");
    }

    /**
     * 测试事务2
     *
     * @throws InterruptedException 中断异常
     */
    public void saveTwoTest() throws InterruptedException {
        User user = new User();
        user.setName("saveTwoTest");
        user.setPassword("123456");
        userServiceImpl.saveUser(user);
    }
}
