package com.example.demo.java.test;

import com.example.demo.java.bean.Father;
import com.example.demo.java.bean.Son;

/**
 * Created by wuxg-a on 2018/2/27.
 */
public class TypeForceTransform {

    public static void main(String[] args) {
        Father father = new Son();
        Son son = (Son)father;

        Father father1 = new Father();
        Son son1 = (Son) father1; //编译出错，ClassCastException
    }
}
