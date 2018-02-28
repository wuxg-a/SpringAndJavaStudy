package com.example.demo.config;

import com.example.demo.converter.MyMessageConverter;
import com.example.demo.service.impl.ScheduledTaskService;
import com.github.kristofa.brave.okhttp.BraveOkHttpRequestResponseInterceptor;
import com.github.kristofa.brave.spring.ServletHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by wuxg-a on 2018/1/11.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    ServletHandlerInterceptor servletHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(servletHandlerInterceptor).addPathPatterns("/**");
    }

    @Bean(initMethod = "initMethod")
    public ScheduledTaskService scheduledTaskService(){
        return new ScheduledTaskService();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(converter());
    }

    @Bean
    public MyMessageConverter converter(){
        return new MyMessageConverter();
    }
}
