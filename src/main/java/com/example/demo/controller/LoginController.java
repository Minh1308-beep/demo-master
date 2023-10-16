package com.example.demo.controller;

import java.io.IOException;

import com.example.demo.model.Account;
import com.example.demo.model.DBCrud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = req.getParameter("user");
        String password = req.getParameter("pass");

        DBCrud dao = new DBCrud();
        Account a = dao.login(username, password);
        if(a == null){
            req.setAttribute("mess", "Wrong username or password");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("acc", a);
            resp.sendRedirect("home");
            
        }
    }
    
}
