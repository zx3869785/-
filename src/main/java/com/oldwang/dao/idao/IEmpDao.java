package com.oldwang.dao.idao;

import com.oldwang.common.Res;
import com.oldwang.controller.vo.DelVO;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.entity.Emp;

import java.rmi.server.ExportException;
import java.util.List;

public interface IEmpDao {
    void delete(Emp emp) throws Exception ;
    void save(Emp emp) throws Exception ;
    void update(Emp emp) throws Exception ;

    List<Emp> findByPage(int start, int size) throws Exception;
    List<Emp> findByName(String name) throws Exception;
    Emp findById(Integer empno) throws Exception;

    List<Emp> findByDept(int deptno) throws Exception;

    void delBatch(List<DelVO> delVOList) throws Exception;
}
