package com.oldwang.ssm.mybaties.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private int id;
    private String username;
    private BigDecimal sal;
    private Date birthday;

    public User() {
    }

    public User(String username, BigDecimal sal, Date birthday) {
        this.username = username;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(int id, String username, BigDecimal sal, Date birthday) {
        this.id = id;
        this.username = username;
        this.sal = sal;
        this.birthday = birthday;
    }
}
