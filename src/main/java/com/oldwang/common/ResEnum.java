package com.oldwang.common;

public enum ResEnum {
    SUCCESS(200,"success"),
    SUCCESS_USER_EXIST(201,"user exist success"),
    SUCCESS_DEL_BATCH(202,"DELETE BATCH SUCCESS"),
    ERROR_USER_EXIST(501,"user exist error"),
    ERROR(500,"error"),
    ERROR_PARAMS_IN_DELBATCH(501,"PARAM CANNOT BE NULL");

    private int status;
    private String msg;

    ResEnum(int status, String msg) {
            this.status=status;
            this.msg=msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
