// Karol Strzelecki ID: 19101653
package com.KarolStrzelecki;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

import static com.KarolStrzelecki.Restaurant.EOF;

public class Server extends Thread {

    // Server is only Consumer model, so it needs only one buffer, and one Reentrant lock shared
    // with Chef class. It contains also printResult() and lineMatcher() method which will help
    // with storing result, and them printing it out


        private List<String> buffer;
        private List<String> served = new ArrayList<>();
        private String color;
        private String name;
        private ReentrantLock bufferLock;

        public Server(String name, List<String> buffer, String color, ReentrantLock bufferLock) {
            this.name = name;
            this.buffer = buffer;
            this.color = color;
            this.bufferLock = bufferLock;
        }

        public void run() {
            while (true) {
                Random random =  new Random();

                bufferLock.lock();
                if (buffer.isEmpty()) {
                    bufferLock.unlock();
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println();
                    resultPrint();
                    bufferLock.unlock();
                    break;
                } else {
                    try {
                        String string = buffer.get(0);
                        lineMatcher(string);

                        System.out.println(color + "Server " + name + " is serving " + buffer.remove(0));
                        Thread.sleep(random.nextInt(500));
                    }catch (InterruptedException ex){
                        ex.printStackTrace();

                    }

                }
                bufferLock.unlock();
            }


        }


    private void lineMatcher(String str) {

        String[] totalSentence = str.split("\\s+");
        List buffer = new ArrayList();
        for (int i = 0; i < totalSentence.length; i++) {
            if (Pattern.matches("\\D+", totalSentence[i])) {
                buffer.add(totalSentence[i]);
            } // I needed to eliminate numbers from order list to count occurencies in resultPrint method




        }
        String key = String.join(" ", buffer);
        served.add(key);
    }

    private void resultPrint(){
        int count = served.size();
        System.out.println(color + "Server " + name + " served " + count + " orders including: ");

        Set<String> mySet = new HashSet<String>(served); // I used properties of the set (only exclusive values)
        for(String s: mySet){

            System.out.println(color + s + " " + Collections.frequency(served,s)); // then i used collections.frequency
            // method to count occurencies of value from set in list of strings

        }

    }



}




