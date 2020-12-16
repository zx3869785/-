package com.oldwang.dao.impl;

import com.oldwang.common.Res;
import com.oldwang.dao.entity.Dept;
import com.oldwang.dao.entity.Emp;
import com.oldwang.dao.idao.IDeptDao;
import com.oldwang.dao.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("deptDao")
public class DeptDaoImpl implements IDeptDao {
    @Override
    public List<Dept> findAll() throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT deptno,dname from dept";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Dept> depts = new ArrayList<>();
        while(rs.next()){
            Dept dept = new Dept();
            dept.setDeptno(rs.getInt(1));
            dept.setDname(rs.getString(2));
            depts.add(dept);
        }
        DBUtil.close(rs,ps,con);
        return depts;
    }
}
