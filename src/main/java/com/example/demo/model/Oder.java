package com.example.demo.model;

public class Oder {
    private int oderId;
    private String date;
    private int cusId;
    private double sum;

    public Oder() {
    }

    public Oder(int oderId, String date, int cusId, double sum) {
        this.oderId = oderId;
        this.date = date;
        this.cusId = cusId;
        this.sum = sum;
    }

    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

}