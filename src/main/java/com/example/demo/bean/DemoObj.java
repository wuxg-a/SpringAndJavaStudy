package com.example.demo.bean;

/**
 * Created by wuxg-a on 2018/2/28.
 */
public class DemoObj {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DemoObj(){

    }
}
