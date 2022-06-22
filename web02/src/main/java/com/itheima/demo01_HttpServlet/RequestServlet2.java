package com.itheima.demo01_HttpServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/r2")
public class RequestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map);
        System.out.println("-----------------------");
        String yonghuming = request.getParameter("yonghuming");
        System.out.println("没有处理编码前:"+yonghuming);
        // 处理
        //String s = new String(yonghuming.getBytes(StandardCharsets.ISO_8859_1), "UTF-8");
        //System.out.println("处理后:"+s);
        String[] aihaos = request.getParameterValues("aihao");
        System.out.println(yonghuming+"----"+ Arrays.toString(aihaos));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
