package com.messages;

import java.util.Random;

public class Reader implements Runnable{

    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();

        for(String latestMessage = message.read(); !latestMessage.equals("Finished");){
            System.out.println(latestMessage);
            latestMessage = message.read();
            try{
                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                //
            }

        }
    }
}
