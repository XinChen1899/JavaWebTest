package org.zuel.app.dao;

import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.zuel.app.module.DeptData;

/**
 * 部门的数据库操作
 * @author 陈昕
 * **/
public class DeptOperationDAO {

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
     * insert new dept to the table "Dept"
     * @param data
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean insertData(DeptData data) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql = "INSERT INTO Dept VALUES(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, data.getId());
            pst.setString(2, data.getName());
            pst.setString(3, data.getType());
            pst.setString(4, data.getDescription());
            pst.setString(5, data.getAddress());
            int i = pst.executeUpdate();
            System.out.printf("插入数据成功，影响了%d行数据\n", i);
        } catch (SQLException e) {
            System.out.println("插入失败，或许该科室已存在，请检查科室编号");
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
     * @param type
     * @param description
     * @param address
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean UpdateData(String id,String name,String type,String description,String address) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        System.out.println(id+name+type);
        try{
            sql="Update dept SET name=?,type=?,description=?,ward_or_address=? WHERE id=?";
            pst=conn.prepareStatement(sql);
            pst.setString(5,id);
            pst.setString(1,name);
            pst.setString(2,type);
            pst.setString(3,description);
            pst.setString(4,address);
            int i=pst.executeUpdate();
            System.out.printf("修改数据成功，影响了%d行数据\n", i);
        }catch(SQLException e){
            System.out.println("修改失败，请检查信息填写是否合法");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get some data from the table "Dept"
     * @param newDept
     * @return deptList
     * @exception SQLException
     * @author 陈昕
     * **/
    public static List<DeptData> readData(DeptData newDept) {
        Connection conn=DataBaseConnection.getConnection();
        DeptData temp;
        List<DeptData> deptList=new LinkedList<DeptData>();
        ResultSet result=null;
        PreparedStatement pst=null;
        try {
            pst=conn.prepareStatement(sql);
            result=pst.executeQuery();
            System.out.println("读取数据......");
            while(result.next())
            {
                temp=new DeptData();
                temp.setId(result.getString(1));
                temp.setName(result.getString(2));
                temp.setType(result.getString(3));
                temp.setDescription(result.getString(4));
                temp.setAddress(result.getString(5));

                newDept.setId(temp.getId());
                newDept.setName(temp.getName());
                newDept.setType(temp.getType());
                newDept.setAddress(temp.getAddress());
                newDept.setDescription(temp.getDescription());
                deptList.add(temp);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }finally {
            release(result,pst,conn);
        }
        return deptList;
    }



    /**
     * delete the data in "Dept", finding by id
     * @param id
     * @return boolean
     * @exception SQLException
     * @author 陈昕
     * **/
    public static boolean deleteData(String id) {
        Connection conn=DataBaseConnection.getConnection();
        PreparedStatement pst=null;
        try {
            sql="DELETE FROM Dept WHERE id="+'\''+id+'\'';
            pst=conn.prepareStatement(sql);
            int i=pst.executeUpdate();
            System.out.println("正在删除数据......");
            System.out.printf("删除成功，影响了%d行数据\n",i);
        }
        catch(SQLException e) {
            System.out.println("删除失败，或许不存在相应科室");
            return false;
        }finally {
            release(pst,conn);
        }
        return true;
    }



    /**
     * read and get all the data from "dept"
     * @return deptList
     * @author 陈昕
     * **/
    public static List<DeptData> readDeptAll() {
        sql="SELECT * FROM dept;";
        return readData(new DeptData());
    }



    /**
     * find a dept by id and get it
     * @param id
     * @param dept
     * @return boolean
     * @author 陈昕
     * **/
    public static boolean findData(String id,DeptData dept) {
        sql="SELECT * FROM dept WHERE id=\'"+id+'\'';
        readData(dept);
        if(dept.getId()==null)
            return false;
        return true;
    }
}
