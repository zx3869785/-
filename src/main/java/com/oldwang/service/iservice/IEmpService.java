package com.oldwang.service.iservice;

import com.oldwang.common.Res;
import com.oldwang.controller.vo.DelVO;
import com.oldwang.dao.entity.Emp;

import java.util.List;

public interface IEmpService {
    public List<Emp> findByPage(int page, int size);
    public List<Emp> findByName(String name);
    public Emp findById(Integer empno);


    String deleteEmp(Emp emp) throws Exception;
    String save(Emp emp);
    String update(Emp emp);

    Res<List<Emp>> findByDept(int deptno);

    Res delBatch(List<DelVO> delVOList);
}
