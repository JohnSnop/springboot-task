package com.wf.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @create 2020-08-28 22:19
 * @desc
 **/
@Service
public class AsyncTaskService {

    @Async
    public void hello() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中----");
    }
}
