package com.example.simple.controller;

import com.example.simple.core.response.Response;
import com.example.simple.domain.User;
import com.example.simple.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户控制器
 * 提供用户相关的REST API接口
 */
@RestController
@RequestMapping("api/")
@Api(tags = "用户管理接口")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 注册测试接口
     * @return 响应结果
     */
    @RequestMapping(value = "register1", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "注册测试接口", notes = "返回注册成功消息")
    public Response register1() {
        return new Response().success("注册成功");
    }

    /**
     * 用户注册
     * @param user 用户对象
     * @return 响应结果
     */
    @RequestMapping(value = "register", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "用户注册", notes = "注册新用户")
    public Response register(User user) {
        try {
            userServiceImpl.saveUser(user);
            return new Response().success("注册成功");
        } catch (Exception e) {
            return new Response().failure("注册失败");
        }
    }

    /**
     * 检查用户名是否可用
     * @param name 用户名
     * @return 响应结果
     */
    @RequestMapping(value = "ajaxcheck", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "检查用户名", notes = "检查用户名是否已被注册")
    public Response registerCheck(String name) {
        try {
            User user = userServiceImpl.queryByName(name);
            if (user == null) {
                return new Response().success("用户名可以注册");
            } else {
                return new Response().failure("用户名已被注册");
            }
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
    }

    /**
     * 用户登录
     * @param user 用户对象
     * @param request HTTP请求对象
     * @return 响应结果
     */
    @RequestMapping(value = "login", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "用户登录", notes = "用户登录验证")
    public Response login(User user, HttpServletRequest request) {
        try {
            User newUser = userServiceImpl.queryUser(user);
            if (newUser != null) {
                request.getSession().setAttribute("username", user.getName());
                return new Response().success("登录成功");
            } else {
                return new Response().failure("登录失败");
            }
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
    }

    /**
     * 查询所有用户
     * @param request HTTP请求对象
     * @return 响应结果
     */
    @RequestMapping(value = "queryAll", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "查询所有用户", notes = "获取所有用户列表")
    public Response queryAll(HttpServletRequest request) {
        try {
            List<User> result = userServiceImpl.queryAll();
            if (result != null) {
                return new Response().success(result);
            } else {
                return new Response().failure("未查到任何用户");
            }
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
    }
}
