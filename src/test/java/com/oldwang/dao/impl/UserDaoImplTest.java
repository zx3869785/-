package com.oldwang.dao.impl;

import com.oldwang.dao.entity.User;
import com.oldwang.service.iservice.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//想要进行测试必须在JUnit里加这两个注解
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoImplTest {
    @Autowired
    IUserService userService;
    @Test
    public void exist() {
    }

    @Test
    public void login() {
        User user = new User("root","12");
        System.out.println(userService.login(user));

    }
}