package org.zuel.app.module;


/**
 * used for dealing with the response
 * @author 陈昕
 * **/
public class ResponseObj {


    /** the code get from WeChat**/
    private int code;


    /** the result massage**/
    private String msg;


    /** openid and session_key from WeChat**/
    private Object data;


    public int getCode(){return code; }


    public void setCode(int code){this.code=code; }


    public String getMsg(){return msg; }


    public void setMsg(String msg){this.msg=msg; }


    public Object getData() { return data; }


    public void setData(Object data) { this.data = data; }
}
