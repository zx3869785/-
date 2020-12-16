package com.oldwang.service.factory;

import com.oldwang.common.Comm;
import com.oldwang.dao.impl.ReportDaoImpl;
import com.oldwang.service.impl.DeptServiceImpl;
import com.oldwang.service.impl.EmpServiceImpl;
import com.oldwang.service.impl.ReportServiceImpl;
import com.oldwang.service.impl.UserServiceImpl;

public class ServicesFactory {
    public static Object getInstance(String serviceName){
        switch (serviceName){
            case Comm.USER:
                return new UserServiceImpl();
            case Comm.EMP:
                return new EmpServiceImpl();
            case Comm.DEPT:
                return new DeptServiceImpl();
            case Comm.DEPT_EMP_REPORT:
                return new ReportServiceImpl();
            default:
                return null;
        }

    }
}
