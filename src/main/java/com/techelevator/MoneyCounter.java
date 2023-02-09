package com.techelevator;

public class MoneyCounter {

    private double currentBalance = 0;
    private int moneyProvided = 0;

    public MoneyCounter(double currentBalance, int moneyProvided){
        this.currentBalance = currentBalance;
        this.moneyProvided = moneyProvided;
    }

    public int getMoneyProvided() {
        return moneyProvided;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getChange(double price){
        return this.currentBalance-price;
    }




}
