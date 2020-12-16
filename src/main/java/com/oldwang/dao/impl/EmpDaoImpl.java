package com.oldwang.dao.impl;

import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.controller.vo.DelVO;
import com.oldwang.dao.entity.Emp;
import com.oldwang.dao.idao.IEmpDao;
import com.oldwang.dao.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {

    @Override
    public void delete(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "DELETE FROM emp WHERE EMPNO=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, emp.getEmpno());
        ps.executeUpdate();
    }

    @Override
    public void save(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "insert into emp(empno,ename,hiredate,sal) values(?,?,?,?) ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, emp.getEmpno());
        ps.setString(2,emp.getEname());
        ps.setDate(3,new Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(4,emp.getSal());
        ps.executeUpdate();
        DBUtil.close2(ps,con);
    }

    @Override
    public void update(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        //ps.setInt(1, emp.getEmpno());
        ps.setString(1,emp.getEname());
        ps.setDate(2,new Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.setInt(4,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close2(ps,con);
    }

    @Override
    public List<Emp> findByPage(int start, int size) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal from emp limit ?,?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,start);
        ps.setInt(2,size);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public List<Emp> findByName(String ename) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal from emp where ename like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,"%"+ename+"%");
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public Emp findById(Integer empno) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal from emp where empno =? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,empno);
        ResultSet rs = ps.executeQuery();
        Emp emp = null;
        while(rs.next()){
            emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
        }
        DBUtil.close(rs,ps,con);
        return emp;
    }

    @Override
    public List<Emp> findByDept(int deptno) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT empno,ename,hiredate,sal from emp where deptno=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,deptno);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while(rs.next()){
            Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return emps;
    }

    @Override
    public void delBatch(List<DelVO> delVOList) throws Exception {
        //方法2--->字符串拼接方式拼接sql语句
        Connection con = DBUtil.getConnection();
        //Buffer 主管的就是同步的
        StringBuilder buffer = new StringBuilder("delete from emp where empno in (");
        for (int i = 0; i < delVOList.size(); i++) {
            if (i==delVOList.size()-1){
                buffer.append(delVOList.get(i).getEmpno()+")");
            }else{
                buffer.append(delVOList.get(i).getEmpno()+",");
            }
        }
        String sql = buffer.toString();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        //方法1--->用事务的方法执行
        /*Connection con = DBUtil.getConnection();
        //1、关闭事务自动提交
        con.setAutoCommit(false);
        //批处理调用statement
        Statement ps = con.createStatement();
        try{
            for(DelVO dv:delVOList){
                //存入语句批处理
                String sql = "delete from emp where empno="+dv.getEmpno();
                ps.addBatch(sql);
            }
            //执行批处理
            ps.executeBatch();
            //2、执行成功自动提交
            con.commit();
        }catch (Exception e){
            e.printStackTrace();
            //3、出现异常 数据库自动回滚
            con.rollback();
        }
*/
        DBUtil.close(null,ps,con);
    }

}
