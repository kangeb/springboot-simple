package com.example.simple.Mapper;

import com.example.simple.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

	User selectUser(User user);

	void insertUser(User user);

	User queryByName(String name);

	List<User> queryAll();
}
	
