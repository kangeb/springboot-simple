package com.kang.springboot.simple.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.kang.springboot.simple.Mapper.UserMapper;
import com.kang.springboot.simple.core.Exception.CustomException;
import com.kang.springboot.simple.domain.User;
import com.kang.springboot.simple.service.IUserService;


@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public User queryUser(User user) {
		//处理自定义异常
		if(user.getName()==null) {
			throw new CustomException("用户名不能为空");
		}		
		return userMapper.selectUser(user);
	}

	public void saveUser(User user) {
		userMapper.insertUser(user);
		
	}

	public User queryByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.queryByName(name);
	}
	
}
