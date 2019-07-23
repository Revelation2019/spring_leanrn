package com.client;

import bean.BeanFactory;
import com.service.AccountService;
import com.service.AccountServiceImpl;

/**
 * 模拟一个表现层
 */
public class Client {

    public static void main( String[] args )
    {
        //创建一个账户业务层对象，执行持久层方法保存账户信息到数据库
//        AccountService accountService = new AccountServiceImpl();
        //使用反射创建对象
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");

        accountService.saveAccount();
    }
}
