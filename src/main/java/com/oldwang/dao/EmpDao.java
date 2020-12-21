package com.oldwang.dao;

import com.oldwang.common.Res;
import com.oldwang.controller.vo.DelVO;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.entity.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.rmi.server.ExportException;
import java.util.Date;
import java.util.List;
@Repository
public interface EmpDao {
    void delete(Emp emp);
    void save(Emp emp);
    void update(Emp emp);

    List<Emp> findByPage(@Param("start") int start,@Param("size") int size);
    List<Emp> findByName(@Param("name") String name);
    Emp findById(@Param("empno") Integer empno);
    List<Emp> findByDept(@Param("deptno") int deptno);
    //动态sql
    List<Emp> findByCon(@Param("ename") String ename,
                        @Param("hiredate") Date hiredate,
                        @Param("sal") BigDecimal sal);
    //动态set
    void dynamicUpdate(Emp emp);
    //foreach
    void delBatch(List<Integer> ids);
    void insBatch(List<Emp> empnos);
}
