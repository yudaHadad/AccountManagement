package com.example.dell.accountmanagement.Model;

/**
 * Created by yuda on 25/06/2017.
 */

public class ExpenseType {
    private int id;
    private String name;
    private int type;

    // create a c'tor
    public ExpenseType(int id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }

    //create a getter and setter
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
