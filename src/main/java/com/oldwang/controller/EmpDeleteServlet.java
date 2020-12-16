package com.oldwang.controller;

import com.alibaba.fastjson.JSON;
import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.common.SpringIOC;
import com.oldwang.dao.entity.Emp;
import com.oldwang.service.iservice.IEmpService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmpDeleteServlet",urlPatterns = {"/empdelete"})
public class EmpDeleteServlet extends HttpServlet {
    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、取值
        //根据所在行的编号进行删除
        int empno = Integer.parseInt(request.getParameter("empno"));
        //2、处理
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp = new Emp();
        emp.setEmpno(empno);
        String msg = empService.deleteEmp(emp);
        if (Comm.SUCCESS.equals(msg)){
            //重定向-->刷新再次进入url
            response.sendRedirect(request.getContextPath()+"/empByPage");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","员工数据删除失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }


    }

}
