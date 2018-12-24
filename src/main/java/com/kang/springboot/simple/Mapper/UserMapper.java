package com.kang.springboot.simple.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kang.springboot.simple.domain.User;


public interface UserMapper {

	@Select("select uuid,name,password,phone,email,remark from ssmapi_user where name=#{name} and password=#{password} ")
	User selectUser(User user);
	@Insert("insert into ssmapi_user(uuid,name,password,phone,email,remark) values(uuid(),#{name},#{password},#{phone},#{email},#{remark})")
	void insertUser(User user);
	@Select("select uuid,name,password,phone,email,remark from ssmapi_user where name=#{name}")
	User queryByName(String name);
	//"SELECT * FROM city"
}
	
