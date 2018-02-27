package com.example.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuxg-a on 2018/2/11.
 */

/**
 *  构造函数，postConstruct, init, before, after执行顺序
 *  =======(构造函数)this is an scheduled task=======
    PostProcessor before get beanName:scheduledTaskService
    PostConstruct
    initMethod
    PostProcessor after get beanName:scheduledTaskService

 总结： 1. 后置处理器的postProcessorBeforeInitailization方法是在bean实例化，依赖注入之后
       2. 自定义初始化方法(init-method、postConstruct之前调用
       3. 后置处理器的postProcessorAfterInitailization方法是在bean实例化、依赖注入及自定义初始化方法之后调用
 */
//@Configuration
public class PostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("PostProcessor before get beanName:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("PostProcessor after get beanName:" + beanName);
        return bean;
    }
}
