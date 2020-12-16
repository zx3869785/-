package com.oldwang.controller;

import com.oldwang.common.Comm;
import com.oldwang.common.SpringIOC;
import com.oldwang.dao.entity.Emp;
import com.oldwang.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpFindByIdServlet",urlPatterns = {"/empById"})
public class EmpFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp = empService.findById(empno);

        //3、反馈-JAVA模板引擎
        if (emp!=null){
            List<Emp> emps = new ArrayList<Emp>();
            emps.add(emp);
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","编号查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        Emp emp = empService.findById(empno);
        //3、反馈-JAVA模板引擎
        if (emp!=null){
            request.setAttribute("emp",emp);
            request.getRequestDispatcher("/updateemp.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","无此用户信息");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
