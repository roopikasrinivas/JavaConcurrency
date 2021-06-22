package com.producerConsumer;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumer implements Runnable {

    public static final String EOF = "EOF";
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        long counter = 0;
        while (true) {
            try {
                if (bufferLock.tryLock()) {
                    try {
                        if (buffer.isEmpty()) {
                            continue;
                        }
                        System.out.println(color + "The counter = " + counter);
                        if (buffer.get(0).equals(EOF)) {
                            System.out.println(color + "Exiting");
                            break;
                        } else {
                            System.out.println(color + "Removed " + buffer.remove(0));
                        }
                    } finally {
                        bufferLock.unlock();
                    }
                } else {
                    counter++;
                }
            }catch(Exception e){
                System.out.println(color + "Could not obtain lock");
            }
        }
    }
}
