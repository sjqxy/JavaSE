package com.sjq.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动
                //Class.forName("com.mysql.jdbc.Driver");
                //2. 获取连接
                String url = "jdbc:mysql:///dab1?useSSL=false";
                String username = "root";
                String password = "root";
                Connection conn = DriverManager.getConnection(url, username, password);
                //3. 定义sql
                String sql = "CREATE table zh(\n" +
                        "   id INT,\n" +
                        "   name VARCHAR(10))";
                //4. 获取执行sql的对象 Statement
                Statement stmt = conn.createStatement();
                //5. 执行sql
                int count = stmt.executeUpdate(sql);//受影响的行数
                //6. 处理结果
                System.out.println(count);
                //7. 释放资源
                stmt.close();
                conn.close();
    }
    }

