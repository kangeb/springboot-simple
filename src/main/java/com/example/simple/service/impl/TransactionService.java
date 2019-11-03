package com.example.simple.service.impl;

import com.example.simple.core.util.TaskThead;
import com.example.simple.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service()
public class TransactionService {
    @Resource
    private UserServiceImpl userServiceImpl;
    @Resource
    private TaskThead taskThead;
    @Transactional()
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

    public void saveTwoTest() throws InterruptedException {
        User user = new User();
        user.setName("saveTwoTest");
        user.setPassword("123456");
        userServiceImpl.saveUser(user);
//		DemoThreadTask task = new DemoThreadTask();
//		Thread t = new Thread(task);
//		t.start();
//		t.join();
//		System.out.println("i am main");
        //throw new RuntimeException();
    }
}
