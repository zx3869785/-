package com.oldwang.dao.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {
    //使用连接池 单例模式 （双重锁模式）（懒汉饿汉模式）
    //饿汉模式dao_c3p0
    private static DataSource ds = new ComboPooledDataSource("dao_c3p0");


    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConnection() throws Exception {

        return ds.getConnection();
    }

    public static void close(ResultSet rs, Statement ps, Connection con) throws SQLException {
        if (rs!=null) rs.close();
        if (ps!=null) ps.close();
        if (con!=null) con.close();
    }

    public static void close2( PreparedStatement ps, Connection con) throws SQLException {
        if (ps!=null) ps.close();
        if (con!=null) con.close();
    }
}
