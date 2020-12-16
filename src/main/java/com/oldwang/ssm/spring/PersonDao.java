package com.oldwang.ssm.spring;

import org.springframework.stereotype.Repository;

//@Repository("personDao")--默认标准写法
@Repository
public class PersonDao {
    public void print(){
        System.out.println("I am Dao");
    }
}
