package com.example.demo.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * Created by wuxg-a on 2018/2/10.
 */
@Service
@Async
public class AsyncService {

    public void executeAsyncTask(Integer num){
        System.out.println("执行异步任务：" + num);
    }

    public void executeAsyncPlus(Integer num){
        System.out.println("执行异步任务Plus：" + (num + 1));
    }

}
