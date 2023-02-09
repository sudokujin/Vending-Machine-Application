package com.techelevator;

public class Candy extends Item {

    public Candy (String name, double price, int inventory, String identifier) {
        super(name, price, inventory, identifier);
    }

    @Override
    public void getSound() {
        System.out.println("Munch Munch, Mmm Mmm Good!");
    }
}
