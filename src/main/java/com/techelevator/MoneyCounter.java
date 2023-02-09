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
        if (this.currentBalance >= 0) {
            final double QUARTER = .25;
            final double DIME = .10;
            final double NICKEL = .05;

            int numberOfQuartersToReturn = (int) (this.currentBalance / QUARTER);
            double centsRemaining = this.currentBalance % QUARTER;
            int numberOfDimes = (int) ( centsRemaining / DIME);
            centsRemaining = centsRemaining % DIME;
            double roundOff = Math.round(centsRemaining*100)/100D;
            int numberOfNickels = (int) (roundOff / NICKEL);

            System.out.println("Quarters to return: " + numberOfQuartersToReturn+ "\nDimes to return: " +  + numberOfDimes + "\nNickels to return: " +  + numberOfNickels);
            setCurrentBalance(0);
        }
    }


    public double getChange(double price){
        return this.currentBalance-price;
    }




}
