package com.example.demo.controller;

import com.example.demo.bean.DemoObj;
import com.example.demo.service.AwareService;
import com.example.demo.service.ProfileService;
import com.example.demo.service.impl.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "advice", method = RequestMethod.GET)
    public void adviceTest(@ModelAttribute("msg")String msg,  DemoObj obj) throws InterruptedException, IOException {
        //http://localhost:9090/advice?id=1&name=wxg
        //由于配置了webDataBinder 所以值id为null (看AdviceTest中的配置)
        System.out.println();
    }

    @RequestMapping(value = "convert", method = RequestMethod.POST)
    @ResponseBody
    public DemoObj messageConverterTest(@ModelAttribute("msg")String msg,  @RequestBody DemoObj obj) throws InterruptedException, IOException {
        //使用postman测试：
        // header : Content-Type  application/x-wisely
        //body： raw txt 1-wuxg
        return obj;
    }
}
