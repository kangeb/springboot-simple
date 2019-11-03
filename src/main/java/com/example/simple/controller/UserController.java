package com.example.simple.controller;


import com.example.simple.core.response.Response;
import com.example.simple.domain.User;
import com.example.simple.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("api/")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	@Resource
	private UserServiceImpl userServiceImpl;
	
		@RequestMapping(value="register1",produces="application/json;charset=utf-8")
		public Response register1(){
			return new Response().success("注册成功");
		};
		@RequestMapping(value="register",produces="application/json;charset=utf-8")
		public Response register(User user){			
			try {
				//执行数据库添加操作
				userServiceImpl.saveUser(user);
				return new Response().success("注册成功");
			} catch (Exception e) {
				return new Response().failure("注册失败");
				
			}
		};
		@RequestMapping(value="ajaxcheck",produces="application/json;charset=utf-8")
		public Response registerCheck(String name){						
			try {
				//执行数据库查找操作
				User user=userServiceImpl.queryByName(name);
				//System.out.println(user.toString());
				if(user==null){	
					//return user;
					return new Response().success("用户名可以注册");
				}else{
					return new Response().failure("用户名已被注册");
				}
				
			} catch (Exception e) {
				//return new User();
				return new Response().failure(e.getMessage());				
			}
		}
		@RequestMapping(value="login",produces="application/json;charset=utf-8")
		public Response login(User user,HttpServletRequest request) throws Exception{			
			try {
				//执行数据库查找操作
				User newUser=userServiceImpl.queryUser(user);
				if(newUser!=null){
					request.getSession().setAttribute("username",user.getName());
					return new Response().success("登录成功");
				}else{
					return new Response().failure("登录失败");
				}
				
			} catch (Exception e) {
				return new Response().failure(e.getMessage());
			}
		}

	@RequestMapping(value="queryAll",produces="application/json;charset=utf-8")
	public Response queryAll(HttpServletRequest request) throws Exception{
		try {
			//执行数据库查找操作
			List<User> result =userServiceImpl.queryAll();

			if(result!=null){
				return new Response().success(result);
			}else{
				return new Response().failure("未查到任何用户");
			}

		} catch (Exception e) {
			return new Response().failure(e.getMessage());
		}
	}
	    		
}
