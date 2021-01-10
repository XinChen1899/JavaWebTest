package org.zuel.app.dao;

import org.zuel.app.module.DoctorData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DoctorOperationDAO {

    /** the SQL command that will be used **/
    private static String sql;



    /**
     * release the ResultSet,PreparedStatement,Connection
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
     * insert new doctor to the table "doctor"
     * @param data
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean insertData(DoctorData data) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="INSERT INTO Doctor VALUES(?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,data.getId());
            pst.setString(2,data.getName());
            pst.setString(3,data.getDept_id());
            pst.setString(4,data.getSex());
            pst.setString(5,data.getPassword());
            int i=pst.executeUpdate();
            System.out.printf("插入数据成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("插入失败，或许该id重合了");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * Update the data in the table "Dept"
     * @param id
     * @param name
     * @param dept_id
     * @param sex
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean updateData(String id,String name,String dept_id,String sex) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try{
            sql="UPDATE doctor SET name=?,dept_id=?,sex=? WHERE id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,dept_id);
            pst.setString(3,sex);
            pst.setString(4,id);
            int i=pst.executeUpdate();
            System.out.printf("修改数据成功，影响了%d行数据\n",i);
        }
        catch(SQLException e){
            System.out.println("数据库修改失败");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get some data from the table "Doctor"
     * @param newDoctor
     * @return doctorList
     * @exception SQLException
     * @author 陈昕
     * **/
    public static List<DoctorData> readData(DoctorData newDoctor) {
        Connection conn=DataBaseConnection.getConnection();
        DoctorData temp;
        List<DoctorData> doctorList=new LinkedList<DoctorData>();
        ResultSet result=null;
        PreparedStatement pst=null;
        try {
            pst=conn.prepareStatement(sql);
            result=pst.executeQuery();
            System.out.println("读取数据......");
            while(result.next())
            {
                temp=new DoctorData();
                temp.setId(result.getString(1));
                temp.setName(result.getString(2));
                temp.setDept_id(result.getString(3));
                temp.setSex(result.getString(4));
                temp.setPassword(result.getString(5));

                newDoctor.setPassword(temp.getPassword());
                newDoctor.setSex(temp.getSex());
                newDoctor.setDept_id(temp.getDept_id());
                newDoctor.setName(temp.getName());
                newDoctor.setId(temp.getId());
                doctorList.add(temp);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }finally {
            release(result,pst,conn);
        }
        return doctorList;
    }



    /**
     * delete the data in "doctor", finding by id
     * @param id
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean deleteData(String id) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="DELETE FROM Doctor WHERE id="+'\''+id+'\'';
            pst=conn.prepareStatement(sql);
            int i=pst.executeUpdate();
            System.out.println("正在删除数据......");
            System.out.printf("删除成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("删除失败，或许不存在该医生");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get all the data from "doctor"
     * @return doctorList
     * @author 陈昕
     * **/
    public static List<DoctorData> readDoctorAll() {
        sql="SELECT * FROM doctor;";
        return readData(new DoctorData());
    }



    /**
     * find a doctor by id and get it
     * @param id
     * @param doctor
     * @return boolean
     * @author 陈昕
     * **/
    public static boolean findData(String id,DoctorData doctor) {
        sql="SELECT * FROM Doctor WHERE id=\'"+id+'\'';
        readData(doctor);
        if(doctor.getId()==null)
            return false;
        return true;
    }
}
