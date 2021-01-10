package org.zuel.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 连接MySQL数据库
 * @author 陈昕
 **/
public class DataBaseConnection {

    /** the value is used for getting the driver of MySQL **/
    private static final String driverName="com.mysql.jdbc.Driver";

    /** the value is the url of the Database of MySQL **/
    private static final String url="jdbc:mysql://127.0.0.1:3306/hospital?useSSL=false";

    /** the name of DB username **/
    private static final String user="root";

    /** the password of DB **/
    private static final String password="3093104a8b27";

    /**
     * 获得数据库连接
     * @return conn
     * @exception Exception
     * @author 陈昕
     * **/
    public static Connection getConnection() {
        Connection conn=null;
        try{
            Class.forName(driverName);
            conn= DriverManager.getConnection(url,user,password);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
