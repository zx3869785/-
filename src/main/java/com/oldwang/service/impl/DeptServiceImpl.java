package com.oldwang.service.impl;

import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.factory.DaoFactory;
import com.oldwang.dao.idao.IDeptDao;
import com.oldwang.service.iservice.IDeptService;

import java.util.ArrayList;
import java.util.List;

public class DeptServiceImpl implements IDeptService {
    IDeptDao deptDao;
    public DeptServiceImpl() {
        deptDao= (IDeptDao) DaoFactory.getInstance(Comm.DEPT);
    }

    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            depts = deptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (depts.size()>0){
            return Res.success(ResEnum.SUCCESS,depts);
        }else{
            return Res.error(ResEnum.ERROR);

        }

    }
}
