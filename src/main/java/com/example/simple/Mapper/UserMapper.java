package com.example.simple.Mapper;


import com.example.simple.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

	@Select("select uuid,name,password,phone,email,remark from ssmapi_user where name=#{name} and password=#{password} ")
	User selectUser(User user);
	@Insert("insert into ssmapi_user(uuid,name,password,phone,email,remark) values(uuid(),#{name},#{password},#{phone},#{email},#{remark})")
	void insertUser(User user);
	@Select("select uuid,name,password,phone,email,remark from ssmapi_user where name=#{name}")
	User queryByName(String name);
	@Select("select uuid,name,password,phone,email,remark from ssmapi_user")
	List<User> queryAll();
	//"SELECT * FROM city"
}
	
