package com.example.demo.controller;

import com.example.demo.service.AwareService;
import com.example.demo.service.ProfileService;
import com.example.demo.service.impl.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by wuxg-a on 2018/2/10.
 */
@RequestMapping("/")
@RestController
public class SpringBootChapter3Controller {

    @Autowired
    private AwareService awareService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "aware", method = RequestMethod.GET)
    public void modifyBeanName() throws InterruptedException, IOException {
        awareService.getBeanName();
    }

    //1. 通过Config添加一个Executor, 通过@EnableAsync
    //2. 添加任务执行类：通过@Async
    @RequestMapping(value = "async", method = RequestMethod.GET)
    public void asyncService() throws InterruptedException, IOException {
        for(int i=0; i<100; i++){
            asyncService.executeAsyncTask(i);
            asyncService.executeAsyncPlus(i);
        }
        System.out.println("async service end!!!");

    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public void profileService() throws InterruptedException, IOException {
       profileService.print();
    }
}
