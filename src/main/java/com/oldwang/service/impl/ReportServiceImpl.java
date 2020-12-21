package com.oldwang.service.impl;

import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.controller.vo.DeptEmpVO;
import com.oldwang.dao.ReportDao;
import com.oldwang.service.dto.DeptEmpDTO;
import com.oldwang.service.iservice.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("reportService")
public class ReportServiceImpl implements IReportService {
    @Autowired
    ReportDao reportDao;

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
