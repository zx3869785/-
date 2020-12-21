package com.oldwang.dao;

import com.oldwang.dao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDao1Test {
    @Autowired
    UserDao userDao;

    @Test
    public void existTest(){
        System.out.println(userDao.exist("root"));
    }

    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("abc");
        user.setPassword("123");
        System.out.println(userDao.login(user));
    }

}