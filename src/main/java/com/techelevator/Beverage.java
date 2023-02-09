package com.techelevator;

public class Beverage extends Item{
    @Override
    public void getSound() {
        System.out.println("Glug Glug, Chug Chug!");
    }
}
