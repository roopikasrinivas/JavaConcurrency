package com.messages;

public class Main {

    public static void main(String[] args){
        Message message = new Message();
        Thread writer = new Thread(new Writer(message));
        writer.start();

        Thread reader = new Thread(new Reader(message));
        reader.start();
    }
}
