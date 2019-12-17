package com.Assignment;

import static com.Assignment.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{


    @Override
    public void run() {
        System.out.println(ANSI_BLUE +"Hello from " + currentThread().getName());
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_BLUE + "two seconds passed and i am on my way!");
    }
}
