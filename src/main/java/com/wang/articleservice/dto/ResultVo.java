package com.wang.articleservice.dto;

/**
 * @author 王乐乐 WLL
 * @Classname ResultVo
 * @Describe:
 * @date 2021/3/3 16:37
 */
public class ResultVo<T> {
    private String status;
    private String msg;
    private T data;

    public ResultVo(T ...data) {
        this.status="0";
        this.msg="success";
        if(data.length>0){
            this.data=data[0];
        }
    }

    public ResultVo(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultVo(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}
