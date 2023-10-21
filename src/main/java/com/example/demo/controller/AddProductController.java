package com.example.demo.controller;

import java.io.IOException;
import com.example.demo.model.DBCrud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addProduct")
public class AddProductController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/admin.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // Lay du lieu tu form cua Browser
        String pname = req.getParameter("name");
        String pprice = req.getParameter("price");
        String pimage = req.getParameter("image");
        String pcategory = req.getParameter("category");
        String pquantity = req.getParameter("quantity");
        String pdescription = req.getParameter("description");

         // Ket noi Database
         DBCrud db = new DBCrud();
         // Them doi tuong vao Product
         db.createProduct(pname, pprice ,pimage, pcategory, pquantity, pdescription);
 
         
         resp.sendRedirect("admin");
    }
    
}
