package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import com.example.demo.model.Cart;
import com.example.demo.model.Category;
import com.example.demo.model.DBCrud;
import com.example.demo.model.Item;
import com.example.demo.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class ProcessController extends HttpServlet{

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
                    o.setMaxAge(0);
                    resp.addCookie(o);
                }
            }
        }
        Cart cart = new Cart(txt, list);
        String id_raw=req.getParameter("id");
        String num_raw=req.getParameter("num");
        int id, num=0;
        try {
            id=Integer.parseInt(id_raw);
            Product p = db.getProductByID2(id);
            int numStore=p.getQuantity();
            num=Integer.parseInt(num_raw);
            if(num == -1 && (cart.getQuantityById(id)<=1)) {
                cart.removeItem(id);
            }else{
                if(num==1 && cart.getQuantityById(id) >=numStore) {
                    num = 0;
                }
                double price=p.getPrice()*2;
                Item t = new Item(p, num, price);
                cart.addItem(t);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        List<Item> items = cart.getItems();
        txt="";
        if(items.size()>0) {
            txt+=items.get(0).getProduct().getId()+":"+items.get(0).getQuantity();
            for(int i=1;i<items.size();i++) {
                txt+="/"+items.get(i).getProduct().getId()+":"+items.get(i).getQuantity();
            }
        }
        Cookie c =new Cookie("cart", txt);
        c.setMaxAge(24*60*60);
        resp.addCookie(c);
        req.setAttribute("cart", c);
        req.getRequestDispatcher("show").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           
    }
}

    
