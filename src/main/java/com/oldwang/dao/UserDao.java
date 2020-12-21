package com.oldwang.dao;

import com.oldwang.dao.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface UserDao {

    int exist(@Param("username")String username);

    User login(User user);
}
