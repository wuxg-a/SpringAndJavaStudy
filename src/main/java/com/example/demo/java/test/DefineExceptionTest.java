package com.example.demo.java.test;

import com.example.demo.java.bean.MyException;
import com.example.demo.java.bean.MyRuntimeException;

/**
 * Created by wuxg-a on 2018/2/28.
 */
public class DefineExceptionTest {
    public static void main(String[] args) {
        int i =1;
        if(i>0){
            //throw new MyException(); //继承Exception的异常为check exception， 必须通过进行处理
            throw new MyRuntimeException(); //继承RuntimeException的异常为uncheck exception, 可以不处理
        }
    }
}
