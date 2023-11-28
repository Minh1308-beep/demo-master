package com.example.demo.controller;

import java.io.IOException;


import com.example.demo.model.Account;
import com.example.demo.model.DBCrud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup-test")
public class SignupTestController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/logintest.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           // TODO Auto-generated method stub
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        String re_pass = req.getParameter("repass");
        if (!password.equals(re_pass)) {
            req.setAttribute("mess", "Passwords do not match");
            req.getRequestDispatcher("/WEB-INF/views/logintest.jsp").forward(req, resp);
        } else {
            DBCrud dao = new DBCrud();
            Account a = dao.checkAccountExists(username);
            if (a == null) {
                dao.signup(username, password);
                resp.sendRedirect("home");
            } else {
                resp.sendRedirect("/WEB-INF/views/logintest.jsp");
            }
        }
        }
    }
    
