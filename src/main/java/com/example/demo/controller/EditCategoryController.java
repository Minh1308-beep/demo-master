package com.example.demo.controller;

import java.io.IOException;

import com.example.demo.model.Category;
import com.example.demo.model.DBCrud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editCategory")
public class EditCategoryController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cid = req.getParameter("cid");

        DBCrud db = new DBCrud();

        Category category = db.getCategoryByID(cid);
        req.setAttribute("detail", category);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/editCategory.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        String cimage = req.getParameter("cimage");
        String cdescription = req.getParameter("cdescription");

        DBCrud db = new DBCrud();
        db.updateCategory(cname, cimage, cdescription, cid);
        resp.sendRedirect("category");
    }
    
}
