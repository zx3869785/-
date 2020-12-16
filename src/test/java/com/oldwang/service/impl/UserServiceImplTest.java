package com.oldwang.service.impl;

import com.alibaba.fastjson.JSON;
import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.service.factory.ServicesFactory;
import com.oldwang.service.iservice.IUserService;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Before;
import org.junit.Test;


public class UserServiceImplTest extends TestCase {
    IUserService userService;

    private static Logger log = Logger.getLogger(UserServiceImplTest.class);

    @Before
    public void setUp(){
        userService = (IUserService) ServicesFactory.getInstance(Comm.USER);
    }

    @Test
    public void testUserExist() throws Exception {
        Res res = userService.userExist("root123");
        log.info(JSON.toJSONString(res));
    }
}