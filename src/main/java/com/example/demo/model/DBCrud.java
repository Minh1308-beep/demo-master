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
        String sql = "SELECT * FROM product;";
        try {
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> listC = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                listC.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return listC;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product\n" + //
                "WHERE category_id = ?";
        try {
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getString(7)));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    public void deleteProduct(String pid) {
        String sql = "DELETE FROM product WHERE id = ?;";
        try {
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void createProduct(String name, String price, String image, String category, String quantity, String description) {
        String sql = "INSERT product (name, price, image, category_id, quantity, description) VALUES (?,?,?,?,?,?)";

        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, image);
            ps.setString(4, category);
            ps.setString(5, quantity);
            ps.setString(6, description);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product getProductByID(String id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery(); 
            while(rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public Product getProductByID2(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery(); 
            while(rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProduct(String name, String price, String image, String category, String pid) {
        String sql ="UPDATE product SET name = ?, price = ?, image = ?, category_id = ? WHERE id = ?";
    
         try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, image);
            ps.setString(4, category);
            ps.setString(5, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     public void deleteCategory(String id) {
        String sql = "DELETE FROM category WHERE id = ?;";
        try {
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

     public void createCategory(String name, String image, String description) {
        String sql = "INSERT category (name, image, description) VALUES (?,?,?)";

        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, description);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category getCategoryByID(String cid) {
        String sql = "SELECT * FROM category WHERE id = ?";
        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery(); 
            while(rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateCategory(String cname, String cimage, String cdescription, String cid) {
        String sql ="UPDATE category SET name = ?, image = ?, description = ? WHERE id = ?";
    
         try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, cimage);
            ps.setString(3, cdescription);
            ps.setString(4, cid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //tim sach theo name
    public List<Product> getProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE name like ?";
        try {
            new MySQLConnector();
            conn = MySQLConnector.getMySQLConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getString(7)));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }


    public static void main(String[] args) {
        DBCrud db = new DBCrud();
        
        List<Product> listD = db.getProductByCID(null);
        for (Product d : listD) {
            System.out.println(d);
        }
    }
}