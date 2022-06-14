package com.sjq.JDBC;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JDBCDemo5_ResultSet {
    Connection conn = null;

    @Before
    public void bf() throws SQLException {
        //1.注册驱动
        //2.获取连接,如果连接的是本地mysql并且端口号是默认的3306,可以省略
        String url = "jdbc:mysql:///dab1?useSSL=false";
        String username = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, username, password);
    }

    @Test
    public void testResultSet() throws Exception {
        //3.定义sql
        String sql = "select * from zh";
        //4.获取statement对象
        Statement stmt = conn.createStatement();
        //5.执行SQL
        ResultSet rs = stmt.executeQuery(sql);
        //6.1光标向下移动到下一行,并且判断有无数据
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id + "  " + name + "   " + money);
            System.out.println();
        }
        rs.close();
        stmt.close();
    }

    @After
    public void af() throws SQLException {
        conn.close();
    }


}
