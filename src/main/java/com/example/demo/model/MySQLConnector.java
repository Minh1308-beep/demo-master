package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    public static Connection getMySQLConnection() {

        //code
        String hostName = "localhost";
        String dbName = "testdemo";
        String userName = "root";
        String password = "21112003";

        return getMyConnection(hostName, dbName, userName, password);

    }

    
    private static Connection getMyConnection(String hostName, String dbName, String userName, String password) {

        //code

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = null;

        //Load driver connect database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionURL, userName, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) 
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


