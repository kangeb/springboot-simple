package com.example.simple.controller;

import com.example.simple.core.response.Response;
import com.example.simple.domain.User;
import com.example.simple.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户控制器
 * 处理用户相关的HTTP请求
 */
@Api(value = "用户管理", tags = "用户相关接口")
@RestController
@RequestMapping("api/")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 测试注册接口
     *
     * @return 响应结果
     */
    @ApiOperation(value = "测试注册", notes = "测试用的注册接口")
    @RequestMapping(value = "register1", produces = "application/json;charset=utf-8")
    public Response register1() {
        return new Response().success("注册成功");
    }

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 注册结果
     */
    @ApiOperation(value = "用户注册", notes = "根据用户信息注册新用户")
    @RequestMapping(value = "register", produces = "application/json;charset=utf-8")
    public Response register(@ApiParam(value = "用户信息", required = true) User user) {
        try {
            // 执行数据库添加操作
            userServiceImpl.saveUser(user);
            return new Response().success("注册成功");
        } catch (Exception e) {
            return new Response().failure("注册失败");
        }
    }

    /**
     * 检查用户名是否可用
     *
     * @param name 用户名
     * @return 检查结果
     */
    @ApiOperation(value = "检查用户名", notes = "检查用户名是否已被注册")
    @RequestMapping(value = "ajaxcheck", produces = "application/json;charset=utf-8")
    public Response registerCheck(@ApiParam(value = "用户名", required = true) String name) {
        try {
            // 执行数据库查找操作
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
     *
     * @param user    用户信息（用户名和密码）
     * @param request HTTP请求对象
     * @return 登录结果
     * @throws Exception 异常
     */
    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @RequestMapping(value = "login", produces = "application/json;charset=utf-8")
    public Response login(@ApiParam(value = "用户信息", required = true) User user,
                          HttpServletRequest request) throws Exception {
        try {
            // 执行数据库查找操作
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
     *
     * @param request HTTP请求对象
     * @return 用户列表
     * @throws Exception 异常
     */
    @ApiOperation(value = "查询所有用户", notes = "获取所有用户信息")
    @RequestMapping(value = "queryAll", produces = "application/json;charset=utf-8")
    public Response queryAll(HttpServletRequest request) throws Exception {
        try {
            // 执行数据库查找操作
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
