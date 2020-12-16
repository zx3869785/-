package com.oldwang.common;

import lombok.Data;

@Data
public class Res<T> {
    private int status;
    private String msg;
    private T data;

    private Res(int status, String msg,T data) {
        this.status=status;
        this.msg=msg;
        this.data=data;
    }

    private Res(int status, String msg){
        this.status=status;
        this.msg = msg;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Res{"+
                "status=" + status +
                ", msg='" + msg+'\'' +
                ", data=" + data +
                '}';
    }

    //success
    public static<T> Res<T> success(ResEnum re,T data){
        return new Res<T>(re.getStatus(),re.getMsg(),data);
    }
    public static<T> Res<T> success(ResEnum re){
        return new Res<T>(re.getStatus(),re.getMsg());
    }
    public static<T> Res<T> success(){
        return new Res(ResEnum.SUCCESS.getStatus(),ResEnum.SUCCESS.getMsg());
    }
    //error
    public static<T> Res<T> error(ResEnum re,T data){
        return new Res<T>(re.getStatus(),re.getMsg(),data);
    }
    public static<T> Res<T> error(ResEnum re){
        return new Res<T>(re.getStatus(),re.getMsg());
    }
    public static<T> Res<T> error(){
        return new Res(ResEnum.ERROR.getStatus(),ResEnum.ERROR.getMsg());
    }
}
