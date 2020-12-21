package com.oldwang.dao;

import com.oldwang.dao.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DeptDaoTest {
    @Autowired
    DeptDao deptDao;

    @Test
    public void deptTest(){
        List<Dept> list =deptDao.findAll();
        for (Dept list1 :list){
            System.out.println(list1.getDeptno());
        }
    }

}