package com.example.demo.service.impl;

import com.example.demo.service.ProfileService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by wuxg-a on 2018/2/10.
 */
@Service
@Profile(value = "dev")
public class DevProfileServiceImpl implements ProfileService {
    @Override
    public void print() {
        System.out.println("current env is : dev");
    }
}
