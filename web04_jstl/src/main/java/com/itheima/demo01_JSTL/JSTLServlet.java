package com.itheima.demo01_JSTL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/jstl")
public class JSTLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("u","张三");
        request.setAttribute("st",1);

        // 存一个集合
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张翠山");
        list.add("张无忌");
        list.add("张三");
        request.setAttribute("li",list);
        request.getRequestDispatcher("/jsp/jstl.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
