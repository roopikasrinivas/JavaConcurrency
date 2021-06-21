package com.basics;

import static com.basics.ThreadColor.ANSI_CYAN;
import static com.basics.ThreadColor.ANSI_RED;

public class JoinAnotherThread {

    public static void main(String[] args){

        System.out.println(ANSI_RED+ "Hello from Main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName(" == Another Thread == ");
        anotherThread.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous my Runnable");
                try{
                    anotherThread.join(1000);
                    System.out.println(ANSI_CYAN+ "AnotherThread terminated, or timed out, so I'm running again");
                }catch(InterruptedException e){
                    System.out.println(ANSI_CYAN + "I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();

    }
}
