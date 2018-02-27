package com.example.demo.service.impl;

import com.example.demo.service.ProfileService;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by wuxg-a on 2018/2/10.
 */
@Service
@Profile(value = "pro")
public class ProProfileServiceImpl implements ProfileService {
    @Override
    public void print() {
        System.out.println("current env is : production");
    }
}
