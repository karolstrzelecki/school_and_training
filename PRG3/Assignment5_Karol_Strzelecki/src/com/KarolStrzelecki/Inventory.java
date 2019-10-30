// Karol Strzelecki id: 19101653
package com.KarolStrzelecki;

import java.io.Serializable;

public class Inventory extends Item implements Serializable {

private String item_SKU;



    public Inventory(String item_SKU, String name, int quantity, double price ) {
        super(name, quantity, price);
        this.item_SKU = item_SKU;
    }

    @Override
    public String toString() {
        return item_SKU + " " + super.toString();
    }
}
