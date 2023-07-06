package org.example;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
    private BlockingQueue<String> queue;
    private final int rateLimit;

    public Producer(BlockingQueue<String> queue, int rateLimit) {
        this.queue = queue;
        this.rateLimit = rateLimit;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Delay producer
                Thread.sleep(rateLimit);

                // Generate data to produce
                String data = generateData(3);

                // Put into the queue
                queue.put(data);

                System.out.println("Produced data: " + data);
                System.out.println("Current queue after producing: " + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateData(final int length) {
        // Generate random string
        return RandomStringUtils.randomAlphanumeric(length);
    }
}