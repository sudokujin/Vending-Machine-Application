package com.techelevator;

public class Beverage extends Item {

    public Beverage (String name, double price, int inventory) {
        super(name, price, inventory);
    }

    @Override
    public void getSound() {
        System.out.println("Glug Glug, Chug Chug!");
    }
}
