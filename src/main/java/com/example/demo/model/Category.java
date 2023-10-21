package com.example.demo.model;

public class Category {
    private int cid;
    private String cname;
    private String cimage;
    private String cdescription;


    public Category() {
    }


    public Category(int cid, String cname, String cimage, String cdescription) {
        this.cid = cid;
        this.cname = cname;
        this.cimage = cimage;
        this.cdescription = cdescription;
    }


    public int getCid() {
        return cid;
    }


    public void setCid(int cid) {
        this.cid = cid;
    }


    public String getCname() {
        return cname;
    }


    public void setCname(String cname) {
        this.cname = cname;
    }


    public String getCimage() {
        return cimage;
    }


    public void setCimage(String cimage) {
        this.cimage = cimage;
    }


    public String getCdescription() {
        return cdescription;
    }


    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }


    
    
}
