package com.ithiema.demo02_resultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC API 详解：ResultSet
 */
public class JDBCDemo5_ResultSet {
    Connection conn=null;
    @Before
    public void bf() throws SQLException {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///jdbc01?useSSL=false";
        String username = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, username, password);
    }
    @Test
    public void testResultSet() throws  Exception {
       //3. 定义sql
        String sql = "select * from zh";
        //4. 获取statement对象
        Statement stmt = conn.createStatement();
        //5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据  getXxx()
            //int id = rs.getInt("id");
            // sql查询出来的第1列
            double id = rs.getDouble("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("--------------");
        }
        rs.close();
        stmt.close();
    }
    @After
    public void af() throws SQLException {
        conn.close();
    }
}
