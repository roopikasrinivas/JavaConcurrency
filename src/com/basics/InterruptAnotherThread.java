package com.basics;

import static com.basics.ThreadColor.ANSI_RED;

public class InterruptAnotherThread {

    public static void main(String[] args){
        System.out.println(ANSI_RED+ "Hello from Main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread ==");
        anotherThread.start();

        anotherThread.interrupt();

        System.out.println(ANSI_RED + "Hello again from main thread");


    }
}
