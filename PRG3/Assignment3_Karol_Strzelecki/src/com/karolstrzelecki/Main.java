// Karol Strzelecki Id: 19101653
package com.karolstrzelecki;

import java.io.*;


public class Main {

    public static void main(String[] args) {

        //==========1=================

        System.out.println("\nTask 1\n");


        // Creating array of Transaction Object

        Transaction [] transactions = {
                new Transaction("16/08/2019", "Open", 100),
                new Transaction("22/08/2019", "Withdraw", 50),
                new Transaction("23/09/2019", "Deposit", 100)

        };

        Transaction [] serializedTransactions = null;
        System.out.println("Before Serialization");
        for(Transaction transaction : transactions){
            System.out.println(transaction);

        }

        System.out.println("================\n");

        // Then Serializng array

        try {
            FileOutputStream fos = new FileOutputStream("transaction.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(transactions);

        // and deseriazing

            FileInputStream fis = new FileInputStream("transaction.bin");
            ObjectInputStream iis = new ObjectInputStream(fis);
            serializedTransactions = (Transaction[]) iis.readObject();

        } catch (Exception e) {

        }
        // and printing it out
        System.out.println("After serialization");
        for (Transaction transaction : serializedTransactions) {
            System.out.println(transaction);
        }


        //========= 2 =============

        System.out.println("\nTask 2\n");


        BankAccount jenny = new BankAccount("Jenny Lee", "16/08/2017", 100);
        BankAccount serializedJenny = null;

        jenny.withdraw("22/08/2019", 200); // This shows message "Insufficient funds!"

        jenny.deposit("23/08/2019", 300);

        jenny.withdraw("23/09/2019", 50);


        // Before Serialization

        System.out.println("\n==== Before Serialization ====\n");
        System.out.println(jenny);
        jenny.getTransactionDetail();

        // Serialization

        try {
            FileOutputStream fos = new FileOutputStream("accountDetails.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jenny);

            // deserializing

            FileInputStream fis = new FileInputStream("accountDetails.bin");
            ObjectInputStream iis = new ObjectInputStream(fis);
            serializedJenny = (BankAccount) iis.readObject();

        } catch (Exception e) {

        }

        // Printing deserialized object data

        System.out.println("\n==== Deserialized object ==== \n" + serializedJenny);
        serializedJenny.getTransactionDetail();



        // ============== 3 ===============
        // Sorry I didn't understood in 100% what this task is about, I think i made my best,
        // sorry for duplicating code, but you haven't told anything about creating one more class

        // Creating/ modifying *.txt file using RandomAccessFile and giving read and write permission with text given in assessment

        System.out.println("\nTask 3 RandomAccessFileClass\n");

        File text = new File ("text.txt"); // I only made that to delete whole text.txt file while closing the program

        try {
            RandomAccessFile file = new RandomAccessFile(text, "rw");
            file.seek(file.length());
            String data = "Would you like to increase your overdraft? Please type Yes/No at the end of the line.  ";
            file.write(data.getBytes());
            file.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // printing out content of text.txt using RandomAccessFile


            try {
                RandomAccessFile file = new RandomAccessFile("text.txt", "r"); // read only permission
                file.seek(0);
                byte[] bytes = new byte[85]; // to read what we wrote in text.txt file we need about 85 element array of bytes
                file.read(bytes);
                System.out.println("That is how the message looks in bytes:");
                System.out.println(bytes);
                String s = new String(bytes);
                System.out.println("And original message in string:");
                System.out.println(s);
                file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }




        // Appending Yes/No
        System.out.println("\n\n Adding Yes \n\n");


        try {
            RandomAccessFile file = new RandomAccessFile("text.txt", "rw");
            file.seek(file.length());
            String data = "Yes";
            file.write(data.getBytes());

            file.close();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // reading one more time

        try {
            RandomAccessFile file = new RandomAccessFile("text.txt", "r"); // read only permission
            file.seek(0);
            byte[] bytes = new byte[90]; // to read what we wrote in text.txt file we need about 90 element array of bytes
            file.read(bytes);
            System.out.println("That is how the message looks in bytes:");
            System.out.println(bytes);
            String s = new String(bytes);
            System.out.println("And original message:");
            System.out.println(s);
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

       text.deleteOnExit(); //this is only to delete file after exit and check if everything works fine


    }
}
