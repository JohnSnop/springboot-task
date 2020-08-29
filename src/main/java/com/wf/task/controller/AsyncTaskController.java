package com.wf.task.controller;

import com.wf.task.service.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-08-28 22:21
 * @desc
 **/
@RestController
public class AsyncTaskController {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @GetMapping("/hello")
    public String hello() {
        asyncTaskService.hello();
        return "success";
    }
}
