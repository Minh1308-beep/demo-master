package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.DBCrud;
import com.example.demo.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBCrud db = new DBCrud();
        List<Product> list = db.getAllProduct();
        Cookie[] arr = req.getCookies();
        String txt ="";
        if(arr != null) {
            for(Cookie o : arr) {
                if(o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    resp.addCookie(o);
                }
            }
        }
        String id=req.getParameter("id");
        String num=req.getParameter("num");
        if(txt.isEmpty()) {
            txt = id+":"+num;
        }else{
            txt = txt+"/"+id+":"+num;
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2*24*60*60);
        resp.addCookie(c);
        req.getRequestDispatcher("home").forward(req, resp);
    }
    
}
