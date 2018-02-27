package com.example.demo.service.impl;

import com.example.demo.service.AwareService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * Created by wuxg-a on 2018/2/10.
 */
@Service
public class AwareServiceImpl implements AwareService, BeanNameAware {

    private String beanName;

    //参数中的beanName为默认的name, 可以通过setBeanName进行修改， 修改后 该对象在spring服务的名字即为修改后的
    @Override
    public void setBeanName(String defaultBeanName) {
        beanName = "AwareServiceModify";
        defaultBeanName = beanName;
    }

    @Override
    public void getBeanName() {
        System.out.println("current bean name:" + beanName);
    }
}

