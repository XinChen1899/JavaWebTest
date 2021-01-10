package org.zuel.app.module;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * the module of registration
 * @author 陈昕
 * **/
public class RegistrationData {


    private String id,patientId,deptId;


    private Date regTime;


    private int price,accept;


    public RegistrationData() {
        id=null;patientId=null;deptId=null;regTime=new Date();price=0;accept=0;
    }


    public RegistrationData(String patientId,String deptId,Date regTime) {
        SimpleDateFormat formater=new SimpleDateFormat();
        formater.applyPattern("yyyyMMdd");
        String time=formater.format(regTime);
        this.id=patientId+deptId+time;//id为病人id、部门id和挂号日期的组合
        this.patientId=patientId;
        this.deptId=deptId;
        this.regTime=regTime;
        if(getWeek().equals("Sat") || getWeek().equals("Sun"))
            price=30;
        else
            price=20;
    }


    public String getId() {
        return id;
    }


    public String getPatientId() {
        return patientId;
    }


    public String getDeptId() {
        return deptId;
    }


    public Date getRegTime() {
        return regTime;
    }


    public int getPrice() {
        return price;
    }


    public int getAccept(){return accept;}


    public void setId(String id) {
        this.id = id;
    }


    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }


    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }


    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public void setAccept(int accept){
        if(accept!=0)
            this.accept=1;
        else
            this.accept=0;
    }


    /**
     * get the weekday of getTime
     * @return week
     * **/
    private String getWeek(){
        SimpleDateFormat sdf=new SimpleDateFormat("E", Locale.ENGLISH);
        String week=sdf.format(regTime);
        return week;
    }


    @Override
    public String toString() {
        char acc;
        if(accept==0)
            acc='否';
        else
            acc='是';
        return "id:"+getId()+" 病人编号:"+getPatientId()+
                " 部门编号:"+getDeptId()+" 挂号时间:"+getRegTime()+" 费用:"+getPrice()+"是否受理:"+acc;
    }


    /**
     * turn the (String)dateTime to the (Date)date
     * @param dateTime
     * @return date
     * @exception java.text.ParseException
     * **/
    public static java.util.Date dateFormatter(String dateTime)
    {
        java.util.Date date=new java.util.Date();
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
        try {
            date=formatter.parse(dateTime);
        }
        catch(java.text.ParseException e) {
            e.getErrorOffset();
        }
        return date;
    }
}
