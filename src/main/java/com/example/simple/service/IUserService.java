package com.example.simple.service;


import com.example.simple.domain.User;

import java.util.List;

public interface IUserService {
	User queryUser(User user);
	void saveUser(User user);
	User queryByName(String name);
	List<User> queryAll();
}
