package com.oldwang.common;

import com.oldwang.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

//执行存储过程
public class test {
    public static void main(String[] args) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "call proc_transfer_money1(?,?,?)";
        CallableStatement cs = con.prepareCall(sql);
        cs.setString(1,"SMITH");
        cs.setString(2,"FORD");
        cs.setBigDecimal(3,new BigDecimal("2000"));
        cs.executeUpdate();
        DBUtil.close(null,cs,con);
    }
}
