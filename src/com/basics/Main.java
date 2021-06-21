package com.basics;

import static com.basics.ThreadColor.*;

public class Main {

    public static void main(String[] args){
        System.out.println(ANSI_RED+ "Hello from Main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread ==");
        anotherThread.start();

        new Thread(() -> System.out.println(ANSI_GREEN+"Hello from the Anonymous thread")).start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous My Runnable ");
            }
        });
        myRunnableThread.start();
        //anotherThread.interrupt();

        System.out.println(ANSI_RED + "Hello again from main thread");


    }
}

