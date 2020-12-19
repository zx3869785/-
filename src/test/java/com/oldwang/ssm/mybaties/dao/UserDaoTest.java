package com.oldwang.ssm.mybaties.dao;

import com.oldwang.ssm.mybaties.entity.User;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void findById() {
        User user = userDao.findById(2);
        TestCase.assertNotNull(user);
        TestCase.assertEquals("dasima",user.getUsername());
        TestCase.assertTrue(user.getId()==2);
        System.err.println(user);
    }

    @Test
    public void findAll(){
        List<User> user = userDao.findAll();
        TestCase.assertNotNull(user);
    }

    @Test
    public void findByPage(){
        userDao.findByPage(1,1).forEach(System.out::println);
    }

    @Test
    public void findByName(){
        userDao.findByName("w").forEach(System.out::println);
    }

    @Test
    public void save() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User("qiezi",new BigDecimal("5000"),sdf.parse("1998-09-25"));
        userDao.save(user);
    }

    @Test
    public void update() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setId(4);
        user.setUsername("kangshifu");
        user.setSal(new BigDecimal("7000"));
        user.setBirthday(sdf.parse("1996-10-15"));
        userDao.update(user);
    }

    @Test
    public void delete(){
        userDao.delete(4);
    }
}