package com.example.demo.controller;

import java.io.IOException;
import com.example.demo.model.DBCrud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addCategory")
public class AddCategoryController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/category.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // Lay du lieu tu form cua Browser
        String cname = req.getParameter("cname");
        String cimage = req.getParameter("cimage");
        String cdescription = req.getParameter("cdescription");

         // Ket noi Database
         DBCrud db = new DBCrud();
         // Them doi tuong vao Product
         db.createCategory(cname, cimage, cdescription);
 
         
         resp.sendRedirect("category");
    }
    
}
