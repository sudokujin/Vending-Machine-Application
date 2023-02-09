package com.techelevator;

public class Chip extends Item {

    public Chip (String name, double price, int inventory, String identifier) {
        super(name, price, inventory, identifier);
    }

    @Override
    public void getSound() {
        System.out.println("Crunch Crunch, It's Yummy!");
    }
}
