package com.oldwang.dao;

import com.oldwang.dao.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmpDaoTest {
    @Autowired
    EmpDao empDao;

    @Test
    public void delete() {
        Emp emp = new Emp();
        emp.setEmpno(7369);
        empDao.delete(emp);
    }

    @Test
    public void save() throws ParseException {
        Emp emp = new Emp();
        emp.setEmpno(7370);
        emp.setEname("DIJIA");
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1998-09-29"));
        emp.setSal(new BigDecimal("2000"));
        empDao.save(emp);
    }

    @Test
    public void update() throws ParseException {
        Emp emp = new Emp();
        emp.setEmpno(7369);
        emp.setEname("aotuman");
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1998-09-25"));
        emp.setSal(new BigDecimal("20000"));
        empDao.update(emp);
    }

    @Test
    public void findByPage() {
        System.out.println(empDao.findByPage(1,1));
    }

    @Test
    public void findByName() {
        System.out.println(empDao.findByName("DIJIA"));
    }

    @Test
    public void findById() {
        System.out.println(empDao.findById(7369));
    }

    @Test
    public void findByDept() {
        System.out.println(empDao.findByDept(10));
    }

    @Test
    public void delBatch() {
    }

    @Test
    public void findConTest() throws ParseException {
        Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-05");
        //empDao.findByCon("b",hiredate,new BigDecimal("2000")).forEach(System.out::println);
        empDao.findByCon(null,hiredate,new BigDecimal("3000")).forEach(System.out::println);
        empDao.findByCon(null,null,new BigDecimal("3000")).forEach(System.out::println);
        empDao.findByCon(null,null,null).forEach(System.out::println);

    }

    @Test
    public void dynamicUpdate(){
        Emp emp = new Emp();
        emp.setEmpno(7369);
        emp.setEname("MengBi");
        empDao.dynamicUpdate(emp);
    }

    @Test
    public void delBatchTest(){
        List<Integer> list = new ArrayList<>();
        list.add(7369);
        list.add(7370);
        empDao.delBatch(list);
    }

    @Test
    public void insBatchTest() throws ParseException {
        Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-05");
        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp(1001,"mafei",hiredate,new BigDecimal("5000")));
        list.add(new Emp(1002,"mafei1",hiredate,new BigDecimal("5001")));
        list.add(new Emp(1003,"mafei2",hiredate,new BigDecimal("5002")));
        empDao.insBatch(list);
    }
}