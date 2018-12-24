package com.kang.springboot.simple.service;

import com.kang.springboot.simple.domain.User;

public interface IUserService {
	public User queryUser(User user);
	public void saveUser(User user);
	public User queryByName(String name);
}
