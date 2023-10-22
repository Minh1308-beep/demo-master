package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.DBCrud;
import com.example.demo.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class DetailProductController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("pid");

        //lay data tu form DBCrud
        DBCrud db = new DBCrud();

        Product p = db.getProductByID(id);

        List<Product> list = db.getAllProduct();

        List<Category> listC = db.getAllCategory();

        
        //set data toi jsp
        req.setAttribute("detail", p);

        req.setAttribute("listP", list);
        req.setAttribute("listCC", listC);

        req.getRequestDispatcher("/WEB-INF/views/Detail.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
}
