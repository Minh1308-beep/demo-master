package com.example.demo.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String image;
    private int category_id;


    public Product() {
    }


    public Product(int id, String name, int price, String image, int category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.category_id = category_id;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public int getCategory_id() {
        return category_id;
    }


    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
}


    