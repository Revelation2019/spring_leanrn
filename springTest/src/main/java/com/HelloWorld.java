package com;

public class HelloWorld {
    public String name;

    public HelloWorld() {
        System.out.println("初始化对象");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("执行了setName方法");
    }

    public void say() {
        System.out.println("Hello world");
    }
}
