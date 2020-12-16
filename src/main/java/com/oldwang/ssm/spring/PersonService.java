package com.oldwang.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service("personService")
@Service
public class PersonService {
    //也能实现注入
    //@Resource
    //自动产生getset方法
    @Autowired
    private PersonDao personDao;

    public void print(){
        personDao.print();
    }

}
