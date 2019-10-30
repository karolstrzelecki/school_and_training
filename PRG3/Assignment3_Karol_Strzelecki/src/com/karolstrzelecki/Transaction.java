// Karol Strzelecki Id: 19101653
package com.karolstrzelecki;

import java.io.Serializable;

public class Transaction implements Serializable {

    private static int tmpId = 1;
    private int id;
    private String date;
    private String type;
    private double amount;

    public Transaction(String date, String type, double amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.id = tmpId++;
    }


    @Override
    public String toString() {
        return id+". " + date + "  " + type + "  " + amount;
    }
}
