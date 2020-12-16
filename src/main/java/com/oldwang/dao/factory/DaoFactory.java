package com.oldwang.dao.factory;

import com.oldwang.common.Comm;
import com.oldwang.dao.impl.DeptDaoImpl;
import com.oldwang.dao.impl.EmpDaoImpl;
import com.oldwang.dao.impl.ReportDaoImpl;
import com.oldwang.dao.impl.UserDaoImpl;
import com.oldwang.service.impl.EmpServiceImpl;
import com.oldwang.service.impl.UserServiceImpl;

public class DaoFactory {
    public static Object getInstance(String daoName){
        switch (daoName){
            case Comm.USER:
                return new UserDaoImpl();
            case Comm.EMP:
                return new EmpDaoImpl();
            case Comm.DEPT:
                return new DeptDaoImpl();
            case Comm.DEPT_EMP_REPORT:
                return new ReportDaoImpl();
            default:
                return null;
        }
    }
}
