package com.oldwang.controller;

import com.alibaba.fastjson.JSON;
import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.service.factory.ServicesFactory;
import com.oldwang.service.iservice.IUserService;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UserExistServlet","/userexist"})
public class UserExistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1、取值
        String username = request.getParameter("username");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setContentType("application/json");
        //2、处理
        //从IUserService接口调用工厂模式ServiceFactor的getInstance方法
        IUserService userService = (IUserService) ServicesFactory.getInstance(Comm.USER);
        //进入到impl实现类的逻辑方法中
        Res res = userService.userExist(username);
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
