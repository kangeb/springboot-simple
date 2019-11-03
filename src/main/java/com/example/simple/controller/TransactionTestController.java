package com.example.simple.controller;

import com.example.simple.service.impl.TransactionService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/transaction")
public class TransactionTestController {
    private static final Logger log = Logger.getLogger(TransactionTestController.class);
    @Resource
    private TransactionService transactionService;
    @RequestMapping("onetest")
    public String oneTest() throws InterruptedException {
        transactionService.saveTest();
        return "success";
    }
    @RequestMapping("twotest")
    public String twotest() throws InterruptedException {
        transactionService.saveTwoTest();
        return "twotest";
    }
}
