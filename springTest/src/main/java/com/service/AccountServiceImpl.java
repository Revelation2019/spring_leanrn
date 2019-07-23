package com.service;

import bean.BeanFactory;
import com.DAO.AccountDAO;
import com.DAO.AccountDAOImpl;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDAO accountDAO = new AccountDAOImpl();
    /**
     * 改用反射来创建对象
     */
//    private AccountDAO accountDAO = (AccountDAO) BeanFactory.getBean("accountDAO");

    @Override
    public void saveAccount() {
        AccountDAO accountDAO = (AccountDAO) BeanFactory.getBean("accountDAO");
        accountDAO.saveAccount();
    }
}
