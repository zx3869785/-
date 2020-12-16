package com.oldwang.dao.idao;

import com.oldwang.dao.entity.User;

import java.sql.SQLException;

public interface IUserDao {

    int exist(String username) throws Exception;

    User login(User user) throws Exception;
}
