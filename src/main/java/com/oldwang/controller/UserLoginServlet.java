package com.oldwang.controller;

import com.alibaba.fastjson.JSON;
import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.common.SpringIOC;
import com.oldwang.dao.entity.User;
import com.oldwang.service.iservice.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UserLoginServlet","/login"})
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、取值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setContentType("application/json");
        //2、处理
        User user = new User(username,password);
        IUserService userService = (IUserService) SpringIOC.getSpringIOC().getBean("userService");
        Res<User> res = userService.login(user);
        //获取网页存储的数据
        HttpSession session = request.getSession();
        session.setAttribute(Comm.CURRENT_USER,res.getData());
        //3、反馈
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //调用了类库fastjson
        Object resJson = JSON.toJSONString(res);
        System.out.println(resJson);
        out.println(resJson);
        out.close();
    }

}
