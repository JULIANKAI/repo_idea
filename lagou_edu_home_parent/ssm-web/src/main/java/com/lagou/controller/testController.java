package com.lagou.controller;

import com.lagou.domain.Test;
import com.lagou.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {

    @Autowired
    private testService testService;

    @RequestMapping("/test")
    public List<Test> findAll(){
        List<Test> allTest = testService.findAllTest();
        System.out.println(allTest);
        return allTest;
    }
}
