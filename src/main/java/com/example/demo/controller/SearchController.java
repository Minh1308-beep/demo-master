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

@WebServlet("/search")
public class SearchController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/HomePage.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
        
        String txtSearch = req.getParameter("txt");

        //lay data tu form DBCrud
        DBCrud db = new DBCrud();


        List<Product> list = db.getProductByName(txtSearch);
        List<Category> listC = db.getAllCategory();

        //tra  du lieu toi jsp
        req.setAttribute("listC", listC);
        req.setAttribute("listP", list);
        req.setAttribute("txtS", txtSearch);
        req.getRequestDispatcher("/WEB-INF/views/searching.jsp").forward(req, resp);
    }
    
}