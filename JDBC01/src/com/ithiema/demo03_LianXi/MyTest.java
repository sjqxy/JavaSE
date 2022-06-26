package com.ithiema.demo03_LianXi;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/*
    综合练习的增删改查

    步骤:

    1: 注册驱动
    2: 获取连接对象
    3: 写带占位符的sql语句
    4: 预编译sql得到执行者
    5: 给占位符设置值
    6: 执行sql
    7: 处理结果
    8: 释放资源
 */
public class MyTest {
    private Connection conn=null;
    @Before
    public void init() throws SQLException {
        /*
         1: 注册驱动  可以省略,mysql自动完成了!
        2: 获取连接对象
         */
        conn = DriverManager.getConnection("jdbc:mysql:///jdbc01?useSSL=false","root","root");
    }
    @Test
    public void testInsert() throws SQLException {
        /*
         3: 写带占位符的sql语句
        4: 预编译sql得到执行者
        5: 给占位符设置值
        6: 执行sql
        7: 处理结果
        8: 释放资源
         */
        // 3: 写带占位符的sql语句
        String sql = "insert into tb_brand values(null,?,?,?,?,?)";
        //4: 预编译sql得到执行者
        PreparedStatement pst = conn.prepareStatement(sql);
        // 5: 给占位符设置值
        pst.setObject(1,"卫龙辣条");
        pst.setObject(2,"卫龙集团");
        pst.setObject(3,100);
        pst.setObject(4,"大家好才是真的好");
        pst.setObject(5,1);
        // 6: 执行sql
        int i = pst.executeUpdate();
        //7: 处理结果
        System.out.println("添加功能:"+i);
        //8: 释放资源
        pst.close();
        conn.close();
    }
    @Test
    public void testSelect() throws SQLException {
        /*
         3: 写带占位符的sql语句
        4: 预编译sql得到执行者
        5: 给占位符设置值
        6: 执行sql
        7: 处理结果
        8: 释放资源
         */
        // 3: 写带占位符的sql语句  只查询状态是1的,且按照ordered升序排列
        String sql = "select * from tb_brand where status = ? order by ordered asc";
        //4: 预编译sql得到执行者
        PreparedStatement pst = conn.prepareStatement(sql);
        // 5: 给占位符设置值
        pst.setObject(1,1);
        // 6: 执行sql
        ResultSet resultSet = pst.executeQuery();
        //7: 处理结果  准备把查询的结果封装到list集合中,集合里面存的是brand对象
        ArrayList<Brand> list = new ArrayList<>();
        while (resultSet.next()){
            // 逐个取值
            int id = resultSet.getInt("id");
            String name = resultSet.getString("brand_name");// 小括号里面的值要和数据库中表中的字段名保持一致
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String desc = resultSet.getString("description");
            int status = resultSet.getInt("status");
            // 封装对象
            Brand b = new Brand(id,name,companyName,ordered,desc,status);
            list.add(b);
        }
        System.out.println("查询功能:");
        for (Brand brand : list) {
            System.out.println(brand);
        }
        //8: 释放资源
        pst.close();
        conn.close();
    }
}
