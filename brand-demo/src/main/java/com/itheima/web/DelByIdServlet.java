package com.itheima.web;

import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delById")
public class DelByIdServlet extends HttpServlet {
    BrandService bs = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            参  调  存  转
         */
        String id = request.getParameter("id");
        int i=bs.delById(id);
        if(i>=1){
            request.setAttribute("msg","删除"+id+"商品成功");
        }else {
            request.setAttribute("msg","删除"+id+"商品失败");
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
