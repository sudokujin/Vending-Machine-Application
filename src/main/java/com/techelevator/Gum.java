package com.techelevator;

public class Gum extends Item {

    public Gum (String name, double price, int inventory) {
        super(name, price, inventory);
    }
    
    @Override
    public void getSound() {
        System.out.println("Chew Chew, Pop!");
    }
}
