// Karol Strzelecki id: 19101653

package com.KarolStrzelecki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShoppingCart {

    private String customerName;
    private String date;
    private List<Item> itemList;


    public ShoppingCart(String customerName, String date) {
        this.customerName = customerName;
        this.date = date;
        this.itemList = new ArrayList<>();
    }


    public void addItem(String str, int n) {

        int pos = searchInventory(str);
        List<Inventory> inventoryList = getList();
        Inventory item = inventoryList.get(pos);

        if (item.getQuantity() >= n) {

            inventoryList.get(pos).subtractQuantity(n);
            itemList.add(new Item(item.getItemName(), n, item.getPrice()));
        } else if (item.getQuantity() > 0 && item.getQuantity() < n) {
            System.out.println("\nSorry we have only " + item.getQuantity() + " pieces of "
                    + item.getItemName() + " and that much will be added to your cart\n");
            itemList.add(new Item(item.getItemName(), item.getQuantity(), item.getPrice()));
            inventoryList.get(pos).subtractQuantity(item.getQuantity());

        } else {
            System.out.println(item.getItemName() + " is not available");
        }

        setList(inventoryList);


    }


    public void removeItem(String str, int n) {
        Comparator<Item> c = new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                return o1.getItemName().toUpperCase().compareTo(o2.getItemName().toUpperCase());
            }
        };
        this.itemList.sort(c);
        int index = Collections.binarySearch(itemList, new Item(str.toUpperCase(), 0, 0), c);
        List<Inventory> inventoryList = getList();

        if (itemList.get(index).getQuantity() > n) {
            itemList.get(index).subtractQuantity(n);
            int pos = searchInventory(str);
            inventoryList.get(pos).addQuantity(n);

        } else {
            itemList.remove(index);
        }

        setList(inventoryList);


    }

    public void sortByPrice() {

        // in this method i created comparator which will sort our array by price value of Item class
        Comparator<Item> c = new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };
        this.itemList.sort(c);


    }


    public int searchInventory(String key) {
        List<Inventory> inventoryList = getList();

        // Creating comparator which will compare item names
        // i used toUpperCase method from string class, which will make search case insesnsitive
        Comparator<Inventory> c = new Comparator<Inventory>() {
            public int compare(Inventory o1, Inventory o2) {
                return o1.getItemName().toUpperCase().compareTo(o2.getItemName().toUpperCase());
            }
        };

        inventoryList.sort(c); // Sorting list because only sorted list works with binarySearch
        int index = Collections.binarySearch(inventoryList, new Inventory(null, key.toUpperCase(), 0, 0), c);
        // Getting index of searched by name item in Inventory ArrayList.
        setList(inventoryList);

        return index;


    }


    public void viewCart() {

        double sum1 = 0;
        DecimalFormat precision = new DecimalFormat("0.00");
        System.out.println(date + " Name: " + customerName);

        for (Item item : itemList) {
            double sum = item.getQuantity() * item.getPrice();
            System.out.println(item.getQuantity() +
                    " " + item.getItemName() + " " + precision.format(sum));
            sum1 += sum;
        } // Loop which prints out our products and sums.
        System.out.println(sum1);

    }
    // Additional methods to operate on serialized file with list


    protected List<Inventory> getList() { // With this one we can get serialized inventory list


        List<Inventory> inventoryList = null;
        try {
            FileInputStream fis = new FileInputStream("inventory.bin");
            ObjectInputStream iis = new ObjectInputStream(fis);
            inventoryList = (List<Inventory>) iis.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inventoryList;
    }


    private void setList(List<Inventory> inventoryList) { // and this method makes us able to save this list
        try {
            FileOutputStream fos = new FileOutputStream("inventory.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inventoryList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
// I know the performance of that solution isn't the best
// but reliability is quite good, and all the process is saved in almost every step

    }


}
