package com.oldwang.service.impl;

import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.controller.vo.DeptEmpVO;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.idao.IReportDao;
import com.oldwang.service.dto.DeptEmpDTO;
import com.oldwang.service.iservice.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("reportService")
public class ReportServiceImpl implements IReportService {
    @Autowired
    IReportDao reportDao;

    @Override
    public Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO) {
        List<DeptEmpDTO> result =null;
        try {
            result = reportDao.makeReportForDeptEmp(deptEmpVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (result!=null&&result.size()>0)?Res.success(ResEnum.SUCCESS,result):Res.error();
    }
}
