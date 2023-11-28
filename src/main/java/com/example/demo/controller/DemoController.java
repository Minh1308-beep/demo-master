package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Cart;
import com.example.demo.model.Category;
import com.example.demo.model.DBCrud;
import com.example.demo.model.Item;
import com.example.demo.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class DemoController extends HttpServlet{

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBCrud db = new DBCrud();
        List<Product> list = db.getAllProduct();
        List<Category> listC = db.getAllCategory();

        Cookie[] arr = req.getCookies();
        String txt ="";
        if(arr != null) {
            for(Cookie o : arr) {
                if(o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, list);
        List<Item> listItem = cart.getItems();
        int n;
        if(listItem!=null) {
            n=listItem.size();
        }else 
            n=0;
        req.setAttribute("size", n);
        req.setAttribute("listP", list);
        req.setAttribute("listC", listC);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }
    
}
