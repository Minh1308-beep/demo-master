package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.DBCrud;
import com.example.demo.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/category")
public class CategoryController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBCrud db = new DBCrud();
        List<Product> listP = db.getAllProduct();
        List<Category> listC = db.getAllCategory();

        req.setAttribute("listPP", listP); 
        req.setAttribute("listCC", listC);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/category.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //super.doPost(req, resp);
    }
    
}
