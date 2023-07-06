package org.example;

import java.util.concurrent.BlockingQueue;

class Consumer extends Thread {
    private BlockingQueue<String> queue;
    private final int rateLimit;

    public Consumer(BlockingQueue<String> queue, int rateLimit) {
        this.queue = queue;
        this.rateLimit = rateLimit;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Delay consumer
                Thread.sleep(rateLimit);

                // Take data from beginning of the queue
                String data = queue.poll();

                // Process the data
                process(data);
                System.out.println("Current queue after consuming: " + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void process(String data) {
        // Process data here
        System.out.println("Consumed data: " + data);
    }
}