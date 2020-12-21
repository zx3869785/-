package com.oldwang.dao;

import com.oldwang.common.Res;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeptDao {
    List<Dept> findAll();

}
