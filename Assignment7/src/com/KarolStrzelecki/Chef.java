// Karol Strzelecki ID 19101653
package com.KarolStrzelecki;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;


import static com.KarolStrzelecki.Restaurant.EOF;

public class Chef extends Thread{
    private String name; // method *.getName() returns only Thread and number,
    // so i had to put this variable to store name of the employee
    private List<String> buffer1;
    private List<String> buffer2;
    // Chef is consumer and producer and one time so it need's to buffer lists:
    // first for orders and it is shared with my own class OrderService
    // second for prepared orders shared with Server
    // same situation is with bufferlocks (Reentrant lock class)
    private List<String> served = new ArrayList<>(); // Array list which stores served items
    private String color;// This variable stores color from class ThreadColor,  in this color will
    // be printed out messages of thread, this is only to improve readability of working threads
    private ReentrantLock bufferLock1;
    private ReentrantLock bufferLock2;




    public Chef(String name, List<String> buffer1, String color, ReentrantLock bufferLock1, List<String> buffer2, ReentrantLock bufferLock2) {
        this.name = name;
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
        this.color = color;
        this.bufferLock1 = bufferLock1;
        this.bufferLock2 = bufferLock2;

    }

    public void run() {
        Random random =  new Random();

        while (true) {
            bufferLock1.lock();
            if (buffer1.isEmpty()) {
                bufferLock1.unlock();
                continue;
            }
            if (buffer1.get(0).equals(EOF)) {
                bufferLock2.lock();
                buffer2.add(EOF);
                System.out.println();
                resultPrint();
                bufferLock1.unlock();
                bufferLock2.unlock();
                break;
            } else {
                bufferLock2.lock();
                try {
                    String str =buffer1.get(0);
                    lineMatcher(str);
                    buffer2.add(str);
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println(color + "Chef " + name + " is preparing " + buffer1.remove(0));

                bufferLock2.unlock();
            }
            bufferLock1.unlock();
        }


    }

    // Method which founds name of

    private void lineMatcher(String str) {

        String[] totalSentence = str.split("\\s+");
        List buffer = new ArrayList();
        for (int i = 0; i < totalSentence.length; i++) {
            if (Pattern.matches("[A-Za-z]+", totalSentence[i])) {
                buffer.add(totalSentence[i]);
            }



        }
        String key = String.join(" ", buffer);
        served.add(key);
    }

    private void resultPrint(){
        int count = served.size();
        System.out.println(color + "Chef " + name + " prepared " + count + " orders including: ");

        Set<String> mySet = new HashSet<String>(served);
            for(String s: mySet){

                System.out.println(color + s + " " +Collections.frequency(served,s));

            }


    }




}
