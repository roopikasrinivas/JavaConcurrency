package com.multipleThreads;

import com.basics.ThreadColor;

public class CountDown {
    private static String m = "";
    private int i;

    public void doCountDown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_PURPLE;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_CYAN;
                break;
            default:
                color = ThreadColor.ANSI_RED;
                break;
        }

        //synchronize using static variable or class // this // .class
        synchronized (m) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }

}

class CountDownThread extends Thread {

    private CountDown countDown;

    public CountDownThread(CountDown countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        countDown.doCountDown();
    }

}
