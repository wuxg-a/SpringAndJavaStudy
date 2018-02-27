package com.example.demo.controller;

/**
 * Created by wuxg-a on 2018/1/3.
 */

import com.example.demo.service.AwareService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RequestMapping("/")
@RestController
public class HomeController{

    @Autowired
    private OkHttpClient client;

    @Autowired
    private AwareService awareService;

    private Random random = new Random();

    @RequestMapping("start")
    public void start() throws InterruptedException, IOException {
//        int sleep= random.nextInt(100);
//        TimeUnit.MILLISECONDS.sleep(sleep);
//        Request request = new Request.Builder().url("http://localhost:9090/foo").get().build();
//        Response response = client.newCall(request).execute();
//        return " [service1 sleep " + sleep+" ms]" + response.body().toString();
        awareService.getBeanName();
    }

    @RequestMapping("foo")
    public String foo() throws InterruptedException, IOException {
        Random random = new Random();
        int sleep= random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);
        Request request = new Request.Builder().url("http://localhost:9091/bar").get().build();  //service3
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        request = new Request.Builder().url("http://localhost:9092/tar").get().build();  //service4
        response = client.newCall(request).execute();
        result += response.body().string();
        return " [service2 sleep " + sleep+" ms]" + result;
    }

    @RequestMapping("bar")
    public String bar() throws InterruptedException, IOException {  //service3 method
        Random random = new Random();
        int sleep= random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);
        return " [service3 sleep " + sleep+" ms]";
    }

    @RequestMapping("tar")
    public String tar() throws InterruptedException, IOException { //service4 method
        Random random = new Random();
        int sleep= random.nextInt(1000);
        TimeUnit.MILLISECONDS.sleep(sleep);
        return " [service4 sleep " + sleep+" ms]";
    }
}
