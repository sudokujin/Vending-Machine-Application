package com.techelevator;

public class MoneyCounter {

    private double currentBalance = 0;
    private int moneyProvided = 0;
    private final double QUARTER = 0.25;
    private final double DIME = 0.10;
    private final double NICKEL = 0.05;

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

    public void feedMoney(int moneyToAdd) {
        if (moneyToAdd >= 0) {
            this.currentBalance += moneyToAdd;
            this.moneyProvided += moneyToAdd;
            setCurrentBalance(this.currentBalance);
        }
    }


    public void finishTransaction(){
        while (this.currentBalance >= 0) {
            //      double  x=1.01;
            //      double y=.25;
            //
            //      System.out.println((int) x/y);
        }
    }

    public double getChange(double price){
        return this.currentBalance-price;
    }




}
