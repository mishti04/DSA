package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerForBlockingQueue implements Runnable {
    private final BlockingQueue queue;
    int i = 0;

    ProducerForBlockingQueue(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (i < 20) {
                queue.put(produce());
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    Object produce() {
        return i++;
    }
}

class ConsumerForBlockingQueue implements Runnable {
    private final BlockingQueue queue;

    ConsumerForBlockingQueue(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    void consume(Object x) {
        System.out.println(x);
    }
}

public class ProducerConsumerUsingBlockingQueue {
    public static void main(String[] args) {
        producerConsumerUsingBlockingQueue();
    }


    private static void producerConsumerUsingBlockingQueue() {
        BlockingQueue q = new ArrayBlockingQueue(10);
        ProducerForBlockingQueue p = new ProducerForBlockingQueue(q);
        ConsumerForBlockingQueue c1 = new ConsumerForBlockingQueue(q);
        ConsumerForBlockingQueue c2 = new ConsumerForBlockingQueue(q);
        ConsumerForBlockingQueue c3 = new ConsumerForBlockingQueue(q);
        new Thread(c1).start();
        new Thread(c3).start();
        new Thread(p).start();
        new Thread(c2).start();
    }
}
