package com.techelevator;

public class Gum extends Item {

    public Gum (String name, double price, int inventory, String identifier) {
        super(name, price, inventory, identifier);
    }
    
    @Override
    public void getSound() {
        System.out.println("Chew Chew, Pop!");
    }
}
