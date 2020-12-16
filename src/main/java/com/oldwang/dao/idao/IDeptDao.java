package com.oldwang.dao.idao;

import com.oldwang.common.Res;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.entity.Emp;

import java.util.List;

public interface IDeptDao {
    List<Dept> findAll() throws Exception;

}
