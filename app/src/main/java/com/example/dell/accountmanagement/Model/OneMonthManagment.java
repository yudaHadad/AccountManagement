package com.example.dell.accountmanagement.Model;

/**
 * Created by yuda on 02/08/2017.
 */

public class OneMonthManagment {
    private int ExpanseType;
    private int ExpanseAmount;
    private int ExpanseGoal;
    private int deviation;

    public OneMonthManagment(int expanseType, int expanseAmount, int expanseGoal, int deviation) {
        ExpanseType = expanseType;
        ExpanseAmount = expanseAmount;
        ExpanseGoal = expanseGoal;
        this.deviation = deviation;
    }

    public int getExpanseType() {
        return ExpanseType;
    }

    public void setExpanseType(int expanseType) {
        ExpanseType = expanseType;
    }

    public int getExpanseAmount() {
        return ExpanseAmount;
    }

    public void setExpanseAmount(int expanseAmount) {
        ExpanseAmount = expanseAmount;
    }

    public int getExpanseGoal() {
        return ExpanseGoal;
    }

    public void setExpanseGoal(int expanseGoal) {
        ExpanseGoal = expanseGoal;
    }

    public int getDeviation() {
        return deviation;
    }

    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }
}
