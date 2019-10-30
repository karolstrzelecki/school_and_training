// Karol Strzelecki id: 19101653

package com.KarolStrzelecki;

import java.io.Serializable;

public class Item implements Serializable {
    private String itemName;
    private int quantity;
    private double price;


    public Item(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return itemName + " " + quantity + " " + price;
    }


    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void subtractQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}

