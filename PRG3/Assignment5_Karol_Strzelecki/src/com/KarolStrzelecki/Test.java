// Karol Strzelecki id: 19101653


package com.KarolStrzelecki;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List inventory = new ArrayList<Inventory>();
        inventory.add(new Inventory("1000", "Apple", 30, 2.50));
        inventory.add(new Inventory("1001", "Orange", 40, 2) );
        inventory.add(new Inventory("2001", "Milk", 10, 2.39));
        inventory.add(new Inventory("2002", "Orange Juice", 20, 1.99));
        inventory.add(new Inventory("3001", "Blue Cheese", 10, 2.25));
        inventory.add(new Inventory("3002", "Cheddar", 20, 2.79) );
        inventory.add(new Inventory("4001", "Chocolate", 40, 2.99) );
        inventory.add(new Inventory("4002", "Candy", 30, 0.99));
        inventory.add(new Inventory("5001", "Beef", 10, 5.00));
        inventory.add(new Inventory("5002", "Chicken", 10, 4.00));

        System.out.println("print out of inventory list:\n");
        for(Object tmp : inventory){
            System.out.println(tmp.toString());
        }

        try {
            FileOutputStream fos = new FileOutputStream("inventory.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inventory);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        // I didn't know how to operate on list created in Test class
        // So i created serialized list (reliable, safe)


        System.out.println("\n\n ==== First Shopping cart ====\n\n");


        ShoppingCart cart1 = new ShoppingCart("Mark", "13/10/2017");
        cart1.addItem("Apple", 2);
        cart1.addItem("Orange", 5);
        cart1.addItem("Milk", 2);
        cart1.addItem("Blue Cheese", 4);
        cart1.addItem("Candy", 25);
        cart1.removeItem("Candy", 5);
        cart1.viewCart();

        inventory = cart1.getList();

        System.out.println("\n\n==== List of stock after first shopping ==== \n\n");
        for (Object o : inventory){
            System.out.println(o.toString());
        }


        System.out.println("\n\n ==== Second Shopping cart ====\n\n");


        ShoppingCart cart2 = new ShoppingCart("Amy", "14/5/2018");

        cart2.addItem("Apple", 2);

        cart2.addItem("Orange", 5);

        cart2.addItem("Milk", 2);

        cart2.addItem("Blue Cheese", 4);

        cart2.addItem("Cheddar", 3);

        cart2.addItem("Beef", 6);

        cart2.addItem("Candy", 20);

        cart2.addItem("Chocolate", 10);

        cart2.addItem("Chicken", 2);

        cart2.removeItem("Chocolate", 5);

        cart2.removeItem("Blue Cheese", 1);

        cart2.sortByPrice();
        cart2.viewCart();


        inventory = cart2.getList();

        System.out.println("\n\n==== List of stock after second shopping ==== \n\n");
        for (Object o : inventory){
            System.out.println(o.toString());
        }


    }
}
