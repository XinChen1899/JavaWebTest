package org.zuel.app.module;


/**
 * the registration module that for user
 * @author 陈昕
 * **/
public class ModifiedReg {


    protected String id,patientName,deptName;


    protected int price;


    protected char accept;


    protected java.util.Date regTime;


    public void setId(String id){this.id=id;}


    public void setPatientName(String patientName){this.patientName=patientName;}


    public void setDeptName(String deptName){this.deptName=deptName;}


    public void setPrice(int price){this.price=price;}


    public void setAccept(char accept){this.accept=accept;}


    public void setRegTime(java.util.Date regTime){this.regTime=regTime;}


    public String getId(){return id;}


    public String getPatientName(){return patientName;}


    public String getDeptName(){return deptName;}


    public int getPrice(){return price;}


    public char getAccept(){return accept;}


    public java.util.Date getRegTime(){return regTime;}


    @Override
    public String toString() {
        return "id:"+getId()+" 病人:"+getPatientName()+
                " 部门:"+getDeptName()+" 挂号时间:"+getRegTime()+" 费用:"+getPrice()+"是否受理:"+accept;
    }
}
