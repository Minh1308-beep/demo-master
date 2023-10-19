package com.example.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List; 

public class DBCrud {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;

    public Account login(String user, String pass) {
        String sql = "SELECT * FROM users WHERE user = ? AND pass = ?";
        
        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Account checkAccountExists(String user) {
        String sql = "SELECT * FROM users WHERE user = ?";
        
        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void signup(String user, String pass) {
        String sql = "INSERT INTO users (user, pass, isAdmin) VALUES (?,?,0)";

        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public static void main(String[] args) {
        DBCrud db = new DBCrud();
        List<Product> list = db.getAllProduct();
        for (Product o : list) {
            System.out.println(o);
        }
    }
}
