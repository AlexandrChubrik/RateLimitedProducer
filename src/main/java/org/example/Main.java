package org.example;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(30);

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter delay in milliseconds between producer items - ");
        int producerRateLimit= sc.nextInt();
        System.out.print("Enter delay in milliseconds between consumer items - ");
        int consumerRateLimit= sc.nextInt();

        Producer producer = new Producer(queue, producerRateLimit);
        producer.start();

        Consumer consumer = new Consumer(queue, consumerRateLimit);
        consumer.start();
    }
}