package com.techelevator;

public class Beverage extends Item {

    public Beverage (String name, double price, int inventory, String identifier) {
        super(name, price, inventory, identifier);
    }

    @Override
    public void getSound() {
        System.out.println("Glug Glug, Chug Chug!");
    }
}
