package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //1、创建IOC(inversion of control,控制反转对象)容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        //2、从IOC容器对象中获取bean实例
//        HelloWorld helloWorld=(HelloWorld) ctx.getBean("helloWorld");
//
//        //3、调用对象方法say
//        helloWorld.say();

    }
}
