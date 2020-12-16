package com.oldwang.service.impl;

import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.controller.vo.DeptEmpVO;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.factory.DaoFactory;
import com.oldwang.dao.idao.IReportDao;
import com.oldwang.service.dto.DeptEmpDTO;
import com.oldwang.service.factory.ServicesFactory;
import com.oldwang.service.iservice.IReportService;

import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements IReportService {
    IReportDao iReportDao;

    public ReportServiceImpl(){
        iReportDao = (IReportDao) DaoFactory.getInstance(Comm.DEPT_EMP_REPORT);
    }
    @Override
    public Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO) {
        List<DeptEmpDTO> result =null;
        try {
            result = iReportDao.makeReportForDeptEmp(deptEmpVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (result!=null&&result.size()>0)?Res.success(ResEnum.SUCCESS,result):Res.error();
    }
}
