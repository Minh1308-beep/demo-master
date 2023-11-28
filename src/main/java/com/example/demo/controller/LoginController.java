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
        String rememberMe = req.getParameter("remember");


        DBCrud dao = new DBCrud();
        Account a = dao.login(username, password);
        if(a == null){
            req.setAttribute("mess", "Wrong username or password");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("acc", a);
            Cookie cuser = new Cookie("user",username);
            Cookie cpass = new Cookie("pass",password);
            Cookie cremember = new Cookie("remember",rememberMe);
            if(rememberMe == null){
                cuser.setMaxAge(0);
                cpass.setMaxAge(0);
                cremember.setMaxAge(0);
            }else {
                cuser.setMaxAge(24*60*60);
                cpass.setMaxAge(24*60*60);
                cremember.setMaxAge(24*60*60);
            }
            resp.addCookie(cuser);
            resp.addCookie(cpass);
            resp.addCookie(cremember);
            resp.sendRedirect("home");       
        }
    }
    
}
