// Karol Strzelecki ID 19101653
package com.KarolStrzelecki;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
    public static final String EOF = "EOF";


    public static void main(String[] args) {



        List<String> buffer1= new ArrayList<String>();
        List<String> buffer2 = new ArrayList<String>();

        ReentrantLock bufferLock1 = new ReentrantLock();
        ReentrantLock bufferLock2 = new ReentrantLock();




        OrderService orders = new OrderService(buffer1, bufferLock1);
        Chef chef1 = new Chef("Mark",buffer1, ThreadColor.ANSI_RED, bufferLock1, buffer2, bufferLock2);
        Chef chef2 = new Chef("John",buffer1, ThreadColor.ANSI_BLUE, bufferLock1, buffer2, bufferLock2);
        Server server1 = new Server("Katie", buffer2, ThreadColor.ANSI_CYAN, bufferLock2);
        Server server2 = new Server("Andrew",buffer2, ThreadColor.ANSI_PURPLE, bufferLock2);
        Server server3 = new Server("Emily",buffer2, ThreadColor.ANSI_WHITE, bufferLock2);




        new Thread(orders).start();
        new Thread(chef1).start();
        new Thread(chef2).start();
        new Thread(server1).start();
        new Thread(server2).start();
        new Thread(server3).start();


    }




}
