package com.producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_CYAN);

        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

  }
}
