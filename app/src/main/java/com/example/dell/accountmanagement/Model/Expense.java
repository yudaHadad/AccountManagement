package com.example.dell.accountmanagement.Model;

import java.util.Date;

/**
 * Created by Dell on 24/06/2017.
 */
public class Expense {
    private int id;
    private String date;
    private int typeId;
    private String methodsOfPayment;
    private double amount;
    private String discraption;

    // create a c'tor
    public Expense(int id, String date, int typeId, String methodsOfPayment, double amount, String discraption) {
        this.id = id;
        this.date = date;
        this.typeId = typeId;
        this.methodsOfPayment = methodsOfPayment;
        this.amount = amount;
        this.discraption = discraption;
    }

    //create a getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return typeId;
    }

    public void setType(int type) {
        this.typeId = type;
    }

    public String getMethodsOfPayment() {
        return methodsOfPayment;
    }

    public void setMethodsOfPayment(String methodsOfPayment) {this.methodsOfPayment = methodsOfPayment;}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDiscraption() {return discraption;}

    public void setDiscraption(String discraption) {this.discraption = discraption;}

    public int getTypeId() {return typeId;}

    public void setTypeId(int typeId) {this.typeId = typeId;}
}
