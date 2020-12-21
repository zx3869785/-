package com.oldwang.service.impl;

import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.DeptDao;
import com.oldwang.service.iservice.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {
    @Autowired
    DeptDao deptDao;

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
