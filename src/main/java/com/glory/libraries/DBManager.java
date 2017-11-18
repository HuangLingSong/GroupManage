package com.glory.libraries;


import java.sql.*;

/**
 * Created by Monster on 2017/10/17.
 */
public class DBManager {
    static String Username = "root";            //数据库用户名
    static String Password = "monster001";      //数据库密码
    static String Databases = "glory";           //数据库名

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost:3306/" + Databases;

    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(dbURL, Username, Password);
//            System.out.println("数据库连接成功！");
            return conn;
        } catch (ClassNotFoundException e) {
//            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
//            System.out.println("数据库连接失败！");
            e.printStackTrace();
            return null;
        }
    }

    public void CloseConnection() {
        if (conn != null) {
            try {
                conn.close();
//                System.out.println("数据库关闭成功！");
            } catch (SQLException e) {
//                System.out.println("数据库关闭失败！");
                e.printStackTrace();
            }
        }
    }

    //执行动态SQL查询  select
    public ResultSet doQurey(String sql, Object[] params) {
        ResultSet resultSet = null;
        conn = this.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            for (int i = 0; params != null && i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            resultSet = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //执行insert update delete等语句
    public int doUpdate(String sql, Object[] params) {
        int resultSet = 0;
        conn = this.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            for (int i = 0; params != null && i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            resultSet = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        dbManager.getConnection();
    }
}
