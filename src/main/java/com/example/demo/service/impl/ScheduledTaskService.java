package com.example.demo.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wuxg-a on 2018/2/10.
 */
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public ScheduledTaskService() {
        System.out.println("=======this is an scheduled task=======");
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct");
    }

    public void initMethod(){
        System.out.println("initMethod");
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次：" + dateFormat.format(new Date()));
    }


}
