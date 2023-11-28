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

@WebServlet("/show")
public class ShowCartController extends HttpServlet{

    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DBCrud db = new DBCrud();
        List<Product> list = db.getAllProduct();

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
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
    
}
