// Karol Strzelecki id: 19101653

package com.assignment4;

import java.text.DecimalFormat;

public enum Ball {    // creating enum
    BASEBALL(149, 73),

    BASKETBALL(624, 239),

    FOOTBALL(450 , 216),

    GOLF(46, 43),

    POOL(156, 60),

    SOFTBALL(180, 97),

    TENNIS(59, 64),

    VOLLEYBALL(260, 218);

    private int size;   // this enum needs two variables
    private int weight;


    Ball(int weight, int size) { // constructor
        this.size = size;
        this.weight = weight;
    }

    // Getters


    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public String getCircumference() {
        DecimalFormat precision = new DecimalFormat("0.00");
        double c = Math.PI* size;

        return precision.format(c);

    }

    public String getVolume(){

        DecimalFormat precision = new DecimalFormat("0.00");
        double v = (4.0/3.0)* Math.PI * Math.pow((size/(double)2),3);
        return precision.format(v);

    }

    // I created own toString method to make code in main class cleaner

    public String toString() {
        return name() + " " + weight + " g " + size + " mm" ;
    }
}
