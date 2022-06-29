package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    BrandService bs = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            参   调   存   转
         */
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        ordered=ordered==null||ordered.equals("")?"0":ordered;
        String description = request.getParameter("description").trim();
        String status = request.getParameter("status");
        // 封装javabean
        Brand b = new Brand(Integer.parseInt(id),brandName,companyName,Integer.parseInt(ordered),description,Integer.parseInt(status));
        //调
        int i=bs.updateBrand(b);
        // 存,存入一个添加的结果是否成功
        request.setAttribute("msg","亲,修改商品:"+brandName+"成功拉");
        // 转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
