package org.zuel.app.module;


/**
 * the module of doctor
 * @author 陈昕
 * **/
public class DoctorData {


    protected String id,name,dept_id,sex,password;


    public DoctorData() {
        id=null;name=null;dept_id=null;password=null;sex=null;
    }


    public DoctorData(String id,String name,String dept_id,String sex,String password) {
        this.id=id;
        this.name=name;
        this.dept_id=dept_id;
        this.sex=sex;
        this.password=password;
    }


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDept_id() {
        return dept_id;
    }


    public String getSex() {
        return sex;
    }


    public String getPassword() {
        return password;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "id:"+getId()+" 姓名:"+getName()+" 性别:"+getSex()+" 部门编号:"+getDept_id();
    }
}
