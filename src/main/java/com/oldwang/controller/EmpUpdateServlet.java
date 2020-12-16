package com.oldwang.controller;

import com.oldwang.common.Comm;
import com.oldwang.dao.entity.Emp;
import com.oldwang.service.factory.ServicesFactory;
import com.oldwang.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EmpUpdateServlet",urlPatterns = {"/empupdate"})
public class EmpUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1、取值
        //取到4个新增字段值
        int empno = Integer.parseInt(request.getParameter("empno"));
        String ename = request.getParameter("ename");
        Date hiredate = null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BigDecimal sal = new BigDecimal(request.getParameter("sal"));
        //2、处理
        IEmpService empService = (IEmpService) ServicesFactory.getInstance(Comm.EMP);
        Emp emp = new Emp(empno ,ename, hiredate, sal);

        String msg = empService.update(emp);
        if (Comm.SUCCESS.equals(msg)) {
            //重定向-->刷新再次进入url
            response.sendRedirect(request.getContextPath() + "/empByPage");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg", "员工数据修改失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


}
