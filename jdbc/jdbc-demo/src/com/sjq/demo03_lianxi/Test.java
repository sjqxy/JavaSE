package com.sjq.demo03_lianxi;

import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
增删改查
1.注册驱动
2.获取连接对象
3.写占有符的SQL语句
4.预编译sql得到执行者
5.给占位符赋值
6.执行sql
7.处理结果
8.释放资源
 */
public class Test {
    private Connection conn=null;
    @Before
    public void  init()throws SQLException {
        conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false","root","root");
    }
    @org.junit.Test
    public void testInsert()throws Exception{
        /*
        3.写占有符的SQL语句
4.预编译sql得到执行者
5.给占位符赋值
6.执行sql
7.处理结果
8.释放资源
         */
        //  3.写占有符的SQL语句
       String sql="insert into tb_brand values(null,?,?,?,?,?)";

        //4.预编译sql得到执行者
        PreparedStatement pre = conn.prepareStatement(sql);
        //5.给占位符设置值
        pre.setObject(1,"卫龙辣条");
        pre.setObject(2,"卫龙集团");
        pre.setObject(3,500);
        pre.setObject(4,"你好我也好");
        pre.setObject(5,1);
        //执行sql
        int i = pre.executeUpdate();
        System.out.println("添加成功"+i);
        //8.释放资源
        pre.close();
        conn.close();
    }
}
