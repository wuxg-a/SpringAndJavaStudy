package com.example.demo.java.test;

import com.example.demo.java.bean.Father;
import com.example.demo.java.bean.Son;

/**
 * Created by wuxg-a on 2018/2/27.
 * 1. 引用类型 类型间的转换
 * 2. 基本数据 类型间的转换
 */
public class TypeForceTransform {

    public static void main(String[] args) {
        /***
         1. 向上转型，即子类对象直接赋给父类引用
         2. 向上类型转换不用强制转换，但会丢失子类特有的方法
         */
        Father father = new Son();
        Son son = (Son)father;

        /***
         1. 向下转型，即父类对象（或指向子类的父类引用）直接赋给子类引用
         2. 直接将父类对象强转为子类对象，将抛ClassCastException；如果指向子类的父类引用强转，成功
         2. 向下类型转换需要强制转换，强制转换可能失败
         */
        Father father1 = new Father();
        Son son1 = (Son)father;
        son1 = (Son)father1; //编译出错，ClassCastException


        /**
         * 需要满足： 1. 两种类型是兼容的；2.目的类型的范围比来源类型大。
         数据值类型按照范围从小到大为：byte，short，char，int，long，float，double
         */
        byte numByte = 1;
        int a = numByte;

//        int numInt = 1;
//        byte b = numInt;

    }
}
