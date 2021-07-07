package com.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuePC {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

    }

    static class Producer implements Runnable{

        BlockingQueue<String> queue;
        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String[] nums = {"1", "2", "3", "4", "5"};
            for(String num : nums){
                try{
                    System.out.println("Produced " + num);
                    queue.put(num);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        BlockingQueue<String> queue;
        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while(true){
                try{
                    System.out.println("Consumed "+ queue.take());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}

