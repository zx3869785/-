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
import java.util.List;

@WebServlet(name = "EmpFindByPageServlet",urlPatterns = {"/empByPage"})
public class EmpFindByPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute(Comm.CURRENT_USER)==null){
            session.setAttribute("errMsg","请先登录");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
       // response.setContentType("application/json");
        //页码、页数
        //应当设置默认页数，否则传来的page为空则会产生bug
        //默认值
        //1、取值
        int page = 1;
        int size = 10;
        String pageParam = request.getParameter("page");
        String sizeParam = request.getParameter("size");
        if (pageParam!=null && !"".equals(pageParam.trim())){
            page = Integer.parseInt(pageParam);
        }
        if (sizeParam!=null && !"".equals(sizeParam.trim())){
            size = Integer.parseInt(sizeParam);
        }
        //2、处理
        IEmpService empService = (IEmpService) SpringIOC.getSpringIOC().getBean("empService");
        List<Emp> emps = empService.findByPage(page,size);

        //3、反馈-JAVA模板引擎
        if (emps!=null&&emps.size()>0){
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else {
            session.setAttribute("errMsg","分页查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
