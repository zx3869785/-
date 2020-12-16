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
import java.util.List;

@WebServlet(name = "EmpFindByNameServlet",urlPatterns = {"/empByName"})
public class EmpFindByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        IEmpService empService = (IEmpService) ServicesFactory.getInstance(Comm.EMP);
        List<Emp> emps = empService.findByName(ename);

        //3、反馈-JAVA模板引擎
        if (emps!=null&&emps.size()>0){
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","姓名查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }

}
