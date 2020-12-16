package com.oldwang.dao.idao;

import com.oldwang.common.Res;
import com.oldwang.controller.vo.DeptEmpVO;
import com.oldwang.service.dto.DeptEmpDTO;

import java.util.List;

public interface IReportDao {

    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO) throws Exception;

}
