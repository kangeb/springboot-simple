package com.example.simple.controller;

import com.example.simple.core.response.Response;
import com.example.simple.domain.User;
import com.example.simple.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "用户管理接口")
@RestController
@RequestMapping("api/")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);

	@Resource
	private UserServiceImpl userServiceImpl;

	@ApiOperation("测试注册接口")
	@GetMapping(value="register1",produces="application/json;charset=utf-8")
	public Response register1(){
		return new Response().success("注册成功");
	}

	@ApiOperation("用户注册")
	@PostMapping(value="register",produces="application/json;charset=utf-8")
	public Response register(@ApiParam("用户信息") User user){
		try {
			userServiceImpl.saveUser(user);
			return new Response().success("注册成功");
		} catch (Exception e) {
			log.error("注册失败", e);
			return new Response().failure("注册失败");
		}
	}

	@ApiOperation("检查用户名是否已注册")
	@GetMapping(value="ajaxcheck",produces="application/json;charset=utf-8")
	public Response registerCheck(@ApiParam("用户名") String name){
		try {
			User user = userServiceImpl.queryByName(name);
			if(user == null){
				return new Response().success("用户名可以注册");
			}else{
				return new Response().failure("用户名已被注册");
			}
		} catch (Exception e) {
			log.error("检查用户名失败", e);
			return new Response().failure(e.getMessage());
		}
	}

	@ApiOperation("用户登录")
	@PostMapping(value="login",produces="application/json;charset=utf-8")
	public Response login(@ApiParam("用户登录信息") User user, HttpServletRequest request) throws Exception{
		try {
			User newUser = userServiceImpl.queryUser(user);
			if(newUser != null){
				request.getSession().setAttribute("username", user.getName());
				return new Response().success("登录成功");
			}else{
				return new Response().failure("登录失败");
			}
		} catch (Exception e) {
			log.error("登录失败", e);
			return new Response().failure(e.getMessage());
		}
	}

	@ApiOperation("查询所有用户列表")
	@GetMapping(value="queryAll",produces="application/json;charset=utf-8")
	public Response queryAll(HttpServletRequest request) throws Exception{
		try {
			List<User> result = userServiceImpl.queryAll();
			if(result != null){
				return new Response().success(result);
			}else{
				return new Response().failure("未查到任何用户");
			}
		} catch (Exception e) {
			log.error("查询用户列表失败", e);
			return new Response().failure(e.getMessage());
		}
	}
}
