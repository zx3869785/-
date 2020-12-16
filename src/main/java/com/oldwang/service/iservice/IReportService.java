package com.oldwang.service.iservice;

import com.oldwang.common.Res;
import com.oldwang.controller.vo.DeptEmpVO;
import com.oldwang.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportService {
    //前后端分离需封装
    Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO);
}
