package com.example.dell.accountmanagement.Model;

/**
 * Created by Dell on 24/06/2017.
 */
public class ExpenseGoal {
    private int id;
    private int typeId;
    private double amount;

    // create a c'tor
    public ExpenseGoal(int id, int typeId, double amount) {
        this.id = id;
        this.typeId = typeId;
        this.amount = amount;
    }

    //create a getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return typeId;
    }

    public void setType(int type) {
        this.typeId = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
