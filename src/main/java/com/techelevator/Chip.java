package com.techelevator;

public class Chip extends Item {

    public Chip (String name, double price, int inventory) {
        super(name, price, inventory);
    }

    @Override
    public void getSound() {
        System.out.println("Crunch Crunch, It's Yummy!");
    }
}
