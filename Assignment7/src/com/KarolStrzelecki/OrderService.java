// Karol Strzelecki ID: 19101653

package com.KarolStrzelecki;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.KarolStrzelecki.Restaurant.EOF;

public class OrderService extends Thread {
    private List<String> buffer;
    private ReentrantLock bufferLock;




    public OrderService(List<String> buffer,  ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    public void run(){
        Random random =  new Random();

        List<String> orderList= null;
        try (Stream<String> lines = Files.lines(Paths.get("orderList.txt"))) {
            orderList = lines.collect(Collectors.toList());
        }catch(Exception e){

        }



        for (String line : orderList){
            try{
                bufferLock.lock();
                buffer.add(line);
                bufferLock.unlock();

                Thread.sleep(random.nextInt(500));
            }catch(InterruptedException ex){
                System.out.println("OrderService was interrupted");
                ex.printStackTrace();

            }


        }
        bufferLock.lock();
        buffer.add(EOF);
        bufferLock.unlock();

    }
}



