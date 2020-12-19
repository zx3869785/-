package com.oldwang.ssm.mybaties.dao;

import com.oldwang.ssm.mybaties.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User findById(@Param("userId")Integer userId);
    public List<User> findAll();
    List<User> findByPage(@Param("start")Integer start,@Param("size")Integer size);
    List<User> findByName(@Param("username")String username);
    int save(User user);
    int update(User user);
    int delete(Integer userId);
}
