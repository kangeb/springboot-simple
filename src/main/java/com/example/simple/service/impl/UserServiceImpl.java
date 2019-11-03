package com.example.simple.service.impl;

import com.example.simple.Mapper.UserMapper;
import com.example.simple.core.Exception.CustomException;
import com.example.simple.domain.User;
import com.example.simple.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
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
	@Override
	//@Transactional(propagation= Propagation.NEVER)
	//@Transactional(propagation= Propagation.MANDATORY)
	@Transactional()
	public void saveUser(User user) {
		userMapper.insertUser(user);
		//throw new RuntimeException();
	}
	@Transactional()
	public void saveOneUser(User user) {
		saveUser(user);
		throw new RuntimeException();
	}
	@Override
	public User queryByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.queryByName(name);
	}
	@Override
	public List<User> queryAll() {
		return userMapper.queryAll();
	}
}
