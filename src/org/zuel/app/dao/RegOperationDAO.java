package org.zuel.app.dao;

import org.zuel.app.module.RegistrationData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import org.zuel.app.module.ModifiedReg;

public class RegOperationDAO {

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
     * insert new registration to the table "reg_record"
     * @param data
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean insertData(RegistrationData data) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="INSERT INTO reg_record VALUES(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,data.getId());
            pst.setString(2,data.getPatientId());
            pst.setString(3,data.getDeptId());
            pst.setDate(4,new Date(data.getRegTime().getTime()) );
            pst.setInt(5,data.getPrice());
            pst.setInt(6,data.getAccept());
            int i=pst.executeUpdate();
            System.out.printf("插入数据成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("插入失败，或许此挂号记录已存在");
            e.printStackTrace();
            return false;
        }
        finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get some data from the table "reg_record","dept","patient"
     * ModifyReg contains the id,patient,dept id,price,accepting of registration
     * @return regList
     * @exception SQLException
     * @author 陈昕
     * **/
    public static List<ModifiedReg> readData() {
        ModifiedReg newReg;
        Connection conn=DataBaseConnection.getConnection();
        List<ModifiedReg> regList=new LinkedList<ModifiedReg>();
        ResultSet result=null;
        PreparedStatement pst=null;
        try {
             pst=conn.prepareStatement(sql);
            result=pst.executeQuery();
            System.out.println("读取数据......");
            while(result.next())
            {
                newReg=new ModifiedReg();
                newReg.setId(result.getString(1));
                newReg.setPatientName(result.getString(2));
                newReg.setDeptName(result.getString(3));
                newReg.setRegTime(result.getDate(4));
                newReg.setPrice(result.getInt(5));
                if(result.getInt(6)==0)
                    newReg.setAccept('否');
                else
                    newReg.setAccept('是');
                regList.add(newReg);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }finally {
            release(result,pst,conn);
        }
        return regList;
    }



    /**
     * delete the data in "reg_record", finding by id
     * @param id
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean deleteData(String id) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="DELETE FROM reg_record WHERE id="+'\''+id+'\'';
            pst=conn.prepareStatement(sql);
            int i=pst.executeUpdate();
            System.out.println("正在删除数据......");
            System.out.printf("删除成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("删除失败");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get all the data from "reg_record"
     * @return regList
     * @author 陈昕
     * **/
    public static List<ModifiedReg> readRegAll() {
        sql="SELECT reg_record.id,patient.name,dept.name,reg_time,price,accept " +
                "FROM reg_record JOIN patient ON Patient_id=patient.id JOIN dept ON dept_id=dept.id";
        return readData();
    }

    /**
     * read and get registration by date and dept id
     * @param time
     * @param dept_id
     * @return regList
     * @author 陈昕
     * **/
    public static List<ModifiedReg> readRegByDateAndDept(java.util.Date time,String dept_id) {
        sql="SELECT reg_record.id,patient.name,dept.name,reg_time,price,accept,accept" +
                "FROM reg_record JOIN patient ON Patient_id=patient.id JOIN dept ON dept_id=dept.id "+
                "WHERE reg_time=\'"+new java.sql.Date(time.getTime())+"\' AND dept_id=\'"+dept_id+'\'';
        return readData();
    }



    /**
     * read and get registration by patient id
     * @param patientId
     * @return regList
     * @author 陈昕
     * **/
    public static List<ModifiedReg> readRegByPatient(String patientId) {
        sql="SELECT reg_record.id,patient.name,dept.name,reg_time,price,accept " +
                "FROM reg_record JOIN patient ON Patient_id=patient.id JOIN dept ON dept_id=dept.id " +
                "WHERE patient_id="+'\''+patientId+'\'';
        return readData();
    }



    /**
     * read and get registration by dept id
     * @param deptId
     * @return regList
     * @author 陈昕
     * **/
    public static List<ModifiedReg> readRegByDept(String deptId) {
        System.out.println(deptId);
        sql="SELECT reg_record.id,patient.name,dept.name,reg_time,price,accept " +
                "FROM reg_record JOIN patient ON patient_id=patient.id JOIN dept ON dept_id=dept.id " +
                "WHERE dept.id=\'"+deptId+"\' AND accept=0";
        return readData();
    }



    /**
     * this function is set for doctor, which can set the "accept" of registration to 1 which means "accepted"
     * @param id
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean acceptReg(String id) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try{
            sql="UPDATE reg_record SET accept=? WHERE id=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1,1);
            pst.setString(2,id);
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

}


