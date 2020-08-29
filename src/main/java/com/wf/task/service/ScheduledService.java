package com.wf.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author wf
 * @create 2020-08-29 9:52
 * @desc
 **/
@Service
public class ScheduledService {

    @Scheduled(cron = "*/5 * * * * *")
    public void hello() {
        System.out.println("ScheduledService===hello()");
    }
}
