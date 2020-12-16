package com.oldwang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.controller.vo.DelVO;
import com.oldwang.service.factory.ServicesFactory;
import com.oldwang.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpDelBatchServlet",urlPatterns = {"/delbatch"})
public class EmpDelBatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empnos = request.getParameter("empnos");
        //将获取的字符串转为集合
        List<DelVO> delVOList = JSON.parseObject(empnos,new TypeReference<List<DelVO>>(){});
        IEmpService empService = (IEmpService) ServicesFactory.getInstance(Comm.EMP);
        Res res = empService.delBatch(delVOList);
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(res));
        out.close();
    }

}
