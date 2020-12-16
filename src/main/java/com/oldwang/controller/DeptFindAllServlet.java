package com.oldwang.controller;

import com.alibaba.fastjson.JSON;
import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.dao.entity.Dept;
import com.oldwang.service.factory.ServicesFactory;
import com.oldwang.service.iservice.IDeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DeptFindAllServlet",urlPatterns = {"/deptall"})
public class DeptFindAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/plain");
        //response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        IDeptService deptService = (IDeptService) ServicesFactory.getInstance(Comm.DEPT);
        Res<List<Dept>> res = deptService.findAll();
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(res));
        out.close();
    }
}
