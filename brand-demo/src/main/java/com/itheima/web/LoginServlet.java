package com.itheima.web;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService us = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            参   调  存  转
         */
        request.setCharacterEncoding("utf-8");
        //1. 接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        User u=us.findUserByUsernameAndPassword(username,password);
        //3. 判断user释放为null
        if(u != null){
            // 造cookie,保存用户名和密码,并响应给浏览器,需要注意中文
            // 获取用户是否勾选了  记住我  功能
            String r = request.getParameter("r");
            Cookie mz = new Cookie("mz", URLEncoder.encode(username,"utf-8"));
            Cookie mm = new Cookie("mm", password);
            mz.setPath("/");
            mm.setPath("/");

            mz.setDomain("localhost");
            mm.setDomain("localhost");

            if("ok".equals(r)){
                // 让cookie活1小时
                mz.setMaxAge(60*60*24*7);
                mm.setMaxAge(60*60*24*7);
            }else {
                // 立刻销毁cookie
                mz.setMaxAge(0);
                mm.setMaxAge(0);
            }
            response.addCookie(mz);
            response.addCookie(mm);
            // 登陆成功
            request.getSession().setAttribute("user",u);
            request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        }else {
            // 登陆失败
            request.setAttribute("msg","亲,用户名或密码不对呀!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}