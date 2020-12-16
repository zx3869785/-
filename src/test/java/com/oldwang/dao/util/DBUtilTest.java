package com.oldwang.dao.util;

import com.oldwang.common.Comm;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilTest extends TestCase {

    @Test
    public void testGetConnection() throws Exception {
        Connection con1 = DBUtil.getConnection();

        String username = "root";
        int flag = 0;
        String sql = "SELECT COUNT(1) FROM user where username=?";
        PreparedStatement ps = con1.prepareStatement(sql);
        ps.setObject(1,username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            flag = rs.getInt(1);
            System.out.println(flag);
        }
        //System.out.println(DBUtil.getDs());
        System.out.println(con1);
        System.out.println("**************");

        Connection con2 = DBUtil.getConnection();

        //System.out.println(DBUtil.getDs());
        System.out.println(con2);
    }
}