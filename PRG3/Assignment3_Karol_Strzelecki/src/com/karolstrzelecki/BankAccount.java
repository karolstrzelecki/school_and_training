// Karol Strzelecki Id: 19101653

package com.karolstrzelecki;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable {
    private static int tmpId = 1000;
    private int id;
    private String name;
    private double balance = 0;
    private List<Transaction> transactions; // I have used List, because this is serializable object, and this is much more flexible
    private transient double overdraft; // We use transient at the time of serialization, if we don’t want to save value of a particular variable in a file,


    public BankAccount(String name, String date, double amount) {
        this.id = tmpId++;
        this.name = name;
        this.transactions = new ArrayList<>();
        Transaction tmp = new Transaction(date, "Opening", amount);
        transactions.add(tmp);
        this.balance = amount;
    }

   public void deposit  (String date, double amount){
        this.balance += amount;
        Transaction tmp = new Transaction(date, "Deposit", amount);
        transactions.add(tmp);
   }

   public void withdraw (String date, double amount){
        if(amount < (balance + overdraft)){
            this.balance -= amount;
            Transaction tmp = new Transaction(date, "Withdraw", amount);
            transactions.add(tmp);}
        else{
            System.out.println("Insufficient funds!");
        }

        // There wasn't anything about that it should throw exception
        // so i think best solution is closing it in if clause
        // and even better one is using Java Beans PropertyVetoException
        // If it should be exception, I made my own Exception Class to show that i can do that kind of thing
        // And there is a lot of try/ catch clauses

   }

    public void getTransactionDetail(){
        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }

    }

    public String toString() {
        return "Account Number: " + id + ". Name: " + name +
                " Balance: " + balance;
    }
}
