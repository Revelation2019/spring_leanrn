package com.DAO;

/**
 * 账户持久层的实现类
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void saveAccount() {
        System.out.println("保存了一个账户到数据库");
    }
}
