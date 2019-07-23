package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1、加载jdbc驱动,mysql8+版本驱动包路径与mysql5+不同，已经变成com.mysql.cj.jdbc.Driver()
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、创建链接,链接mysql8服务需要添加两个参数useSSL=false&serverTimezone=GMT
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT", "root", "123456");
        //3、操作数据库与处理对象
        PreparedStatement preparedStatement = con.prepareStatement("select * from student");
        //4、执行sql语句，得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5、遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6、关闭资源
        resultSet.close();
        preparedStatement.close();
        con.close();
    }
}
