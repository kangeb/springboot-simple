package com.example.simple.controller;

import com.example.simple.service.impl.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 事务测试控制器
 * 用于测试事务相关功能
 */
@Api(value = "事务测试", tags = "事务测试接口")
@RestController
@RequestMapping("api/transaction")
public class TransactionTestController {

    private static final Logger log = Logger.getLogger(TransactionTestController.class);

    @Resource
    private TransactionService transactionService;

    /**
     * 测试事务1
     *
     * @return 测试结果
     * @throws InterruptedException 中断异常
     */
    @ApiOperation(value = "事务测试1", notes = "测试事务传播行为")
    @RequestMapping("onetest")
    public String oneTest() throws InterruptedException {
        transactionService.saveTest();
        return "success";
    }

    /**
     * 测试事务2
     *
     * @return 测试结果
     * @throws InterruptedException 中断异常
     */
    @ApiOperation(value = "事务测试2", notes = "测试事务传播行为")
    @RequestMapping("twotest")
    public String twotest() throws InterruptedException {
        transactionService.saveTwoTest();
        return "twotest";
    }
}
