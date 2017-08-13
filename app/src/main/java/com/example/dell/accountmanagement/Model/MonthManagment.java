package com.example.dell.accountmanagement.Model;

/**
 * Created by yuda on 31/07/2017.
 */

public class MonthManagment {
    private int sumIncomes;
    private int sumExpanses;
    private int deviation;
    private int month;

    public MonthManagment(int sumIncomes, int sumExpanses, int deviation, int month) {
        this.sumIncomes = sumIncomes;
        this.sumExpanses = sumExpanses;
        this.deviation = deviation;
        this.month = month;
    }

    public int getSumIncomes() {
        return sumIncomes;
    }

    public void setSumIncomes(int sumIncomes) {
        this.sumIncomes = sumIncomes;
    }

    public int getSumExpanses() {
        return sumExpanses;
    }

    public void setSumExpanses(int sumExpanses) {
        this.sumExpanses = sumExpanses;
    }

    public int getDeviation() {
        return deviation;
    }

    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
