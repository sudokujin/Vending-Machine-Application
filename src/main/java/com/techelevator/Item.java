package com.techelevator;

public abstract class Item {
    private String name;
    private double price;
    private int inventory;
    private String identifier;

    public Item(String name,  double price, int inventory, String identifier) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.identifier = identifier;
    }

    private final int MIN_COUNT = 0;
    private final int MAX_COUNT = 5;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getIdentifier() {
        return identifier;
    }

   //abstract methods
    public abstract void getSound();
    
}
