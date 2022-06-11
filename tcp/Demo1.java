package com.sjq.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql:///dab1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql1 = "CREATE table zh1(\n" +
                "   id INT,\n" +
                "   name VARCHAR(10))";
        String sqll2 = "CREATE table zh2(\n" +
                "   id INT,\n" +
                "   name VARCHAR(10))";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        try {
            conn.setAutoCommit(false);
            //5. 执行sql
            int count = stmt.executeUpdate(sql1);//受影响的行数
            int count2 = stmt.executeUpdate(sqll2);
            //6. 处理结果
            System.out.println(count);
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            conn.rollback();
            throwables.printStackTrace();
        }
        //7. 释放资源
        stmt.close();
        conn.close();
    }
}
