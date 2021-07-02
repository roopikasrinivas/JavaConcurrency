package com.messages;

import java.util.Random;
import java.util.concurrent.Callable;

public class Writer implements Runnable{

    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run(){
       String[] messages = {
               "Humpty Dumpty sat on a wall",
               "Humpty Dumpty had a great fall",
               "All the king's horses and all the king's men",
               "Couldn't put Humpty together again"
       };

        Random random = new Random();

        for(String s : messages){
            message.write(s);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                //
            }
        }
        message.write("Finished");

    }
}
