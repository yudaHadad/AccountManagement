package com.example.dell.accountmanagement.Model;

/**
 * Created by Dell on 24/06/2017.
 */
public class Income
{
    private int id;
    private String type;
    private int month;
    private int isOneTimeIncome;
    private double amount;
    private int year;

    // create a c'tor
    public Income(int id, String type, int month, int isOneTimeIncome, double amount, int year) {
        this.id = id;
        this.type = type;
        this.month = month;
        this.isOneTimeIncome = isOneTimeIncome;
        this.amount = amount;
        this.year = year;
    }

    //create a getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getIsOneTimeIncome() {
        return isOneTimeIncome;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setIsOneTimeIncome(int isOneTimeIncome) {
        this.isOneTimeIncome = isOneTimeIncome;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmpunt(double amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
