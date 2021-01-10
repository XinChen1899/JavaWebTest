package org.zuel.app.dao;

import org.zuel.app.module.PatientData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PatientOperationDAO {

    /** the SQL command that will be used **/
    private static String sql;



    /**
     * release the PreparedStatement,Connection
     * @param result
     * @param pst
     * @param conn
     * @exception SQLException
     * @author 陈昕
     * **/
    private static void release(ResultSet result,PreparedStatement pst,Connection conn){
        try{pst.close();result.close();conn.close();}
        catch(SQLException e){}
    }



    /**
     * release the PreparedStatement,Connection
     * @param pst
     * @param conn
     * @exception SQLException
     * @author 陈昕
     * **/
    private static void release(PreparedStatement pst,Connection conn){
        try{pst.close();conn.close();}
        catch(SQLException e){}
    }



    /**
     * insert new patient to the table "patient"
     * @param data
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean insertData(PatientData data) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="INSERT INTO Patient VALUES(?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,data.getId());
            pst.setString(2,data.getName());
            pst.setString(3,data.getSex());
            pst.setInt(4,data.getAge());
            pst.setString(5,data.getPassword());
            int i=pst.executeUpdate();
            System.out.printf("插入数据成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("插入失败，或许id重合了");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * Update the data in the table "patient"
     * @param id
     * @param name
     * @param sex
     * @param age
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean updateData(String id,String name,String sex,int age) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try{
            sql="UPDATE Patient SET name=?,sex=?,age=? WHERE id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,sex);
            pst.setInt(3,age);
            pst.setString(4,id);
            int i=pst.executeUpdate();
            System.out.printf("修改数据成功，影响了%d行数据\n",i);
        }catch(SQLException e){
            System.out.println("修改失败");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get some data from the table "patient"
     * @param newPatient
     * @return patientList
     * @exception SQLException
     * @author 陈昕
     * **/
    public static List<PatientData> readData(PatientData newPatient) {
        PatientData temp;
        Connection conn=DataBaseConnection.getConnection();
        List<PatientData> patientList=new LinkedList<PatientData>();
        ResultSet result=null;
        PreparedStatement pst=null;
        try {
            pst=conn.prepareStatement(sql);
            result=pst.executeQuery();
            System.out.println("读取数据......");
            while(result.next())
            {
                temp=new PatientData();
                temp.setId(result.getString(1));
                temp.setName(result.getString(2));
                temp.setPassword(result.getString(5));
                temp.setAge(result.getInt(4));
                temp.setSex(result.getString(3));

                newPatient.setId(temp.getId());
                newPatient.setName(temp.getName());
                newPatient.setSex(temp.getSex());
                newPatient.setAge(temp.getAge());
                newPatient.setPassword(temp.getPassword());
                patientList.add(temp);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }finally {
            release(result,pst,conn);
        }
        return patientList;
    }



    /**
     * delete the data in "patient", finding by id
     * @param id
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean deleteData(String id) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="DELETE FROM Patient WHERE id="+'\''+id+'\'';
            pst=conn.prepareStatement(sql);
            int i=pst.executeUpdate();
            System.out.println("正在删除数据......");
            System.out.printf("删除成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("删除失败，或许不存在该病人");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get all the data from "patient"
     * @return patientList
     * @author 陈昕
     * **/
    public static List<PatientData> readPatientAll() {
        sql="SELECT * FROM patient;";
        return readData(new PatientData());
    }



    /**
     * read and get the patient who has a registration in this dept
     * @param deptId
     * @return patientList
     * @author 陈昕
     * **/
    public static List<PatientData> readPatientByDept(String deptId) {
        sql="SELECT id,name,sex,age FROM Patient WHERE id IN" +
                "(SELECT patient_id FROM reg_record WHERE dept_id=\'"+deptId+"\')";
        return readData(new PatientData());
    }



    /**
     * find a patient by id and get it
     * @param id
     * @param patient
     * @return boolean
     * @author 陈昕
     * **/
    public static boolean findData(String id,PatientData patient) {
        sql="SELECT * FROM patient where id=\'"+id+'\'';
        readData(patient);
        if(patient.getId()==null)
            return false;
        return true;
    }
}
