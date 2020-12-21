package com.oldwang.dao;

import com.oldwang.common.Res;
import com.oldwang.controller.vo.DeptEmpVO;
import com.oldwang.service.dto.DeptEmpDTO;

import java.util.List;

public interface ReportDao {

    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO);

}
