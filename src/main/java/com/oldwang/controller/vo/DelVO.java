package com.oldwang.controller.vo;

import java.io.Serializable;

//序列化
public class DelVO implements Serializable {
    private int empno;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }
}
