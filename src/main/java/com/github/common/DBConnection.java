package com.github.common;
import java.sql.*;

/**
 * Created by guohua.lin on 2017/3/9.
 */
public class DBConnection {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost:3306/nimdatabase";
    private String dbUser = "root";
    private String dbPass = "123456";

    public Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int insert(String userEmail, String userPassword, String currentDate, String status){
        String sql = "insert into nim_user(email,password,date,planstatus) values(?,?,?,?)";
        Connection cnn = getConn();
        int i =0 ;
        try {
            PreparedStatement preStmt =cnn.prepareStatement(sql);
            preStmt.setString(1,userEmail);
            preStmt.setString(2,userPassword);
            preStmt.setString(3,currentDate);
            preStmt.setString(4,status);
            i = preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return i;
    }

    public int update(String userEmail, String currentDate, String status){
        String sql="update nim_user set date = ?,planstatus = ? where email = ?";
        Connection cnn=getConn();
        int i = 0;
        try {
            PreparedStatement preStmt =cnn.prepareStatement(sql);
            preStmt.setString(1,currentDate);
            preStmt.setString(2,status);
            preStmt.setString(3,userEmail);
            i = preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  i;
    }
}
