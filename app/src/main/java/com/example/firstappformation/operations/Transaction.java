package com.example.firstappformation.operations;

public class Transaction {

    private String day;
    private String month;
    private String title;
    private double amount;


    public Transaction(String day, String month, String title, double amount) {
        this.day = day;
        this.month = month;
        this.title = title;
        this.amount = amount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public boolean differentDate(Transaction object) {
        return !(getMonth().equals(object.getMonth())
                && getDay().equals(object.getDay()));
    }
}
