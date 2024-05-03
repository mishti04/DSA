package ProducerConsumer;

import java.util.PriorityQueue;
import java.util.Queue;

 class Producer implements Runnable {
    private final Queue queue;
    int i = 0;

    Producer(Queue q) {
        queue = q;
    }

    public void run() {
        try {
            while (i < 100) {
                queue.add(produce());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    Object produce() {
        return i++;
    }
}

class Consumer implements Runnable {
    private final Queue queue;

    Consumer(Queue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.remove());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void consume(Object x) {
        System.out.println(x);
    }
}

public class ProducerConsumerUsingNormalQueue {

    public static void main(String[] args) {
        producerConsumerUsingNormalQueue();
    }

    private static void producerConsumerUsingNormalQueue() {
        PriorityQueue<Integer> q = new PriorityQueue(10);
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        Consumer c3 = new Consumer(q);
        new Thread(c1).start();
        new Thread(c3).start();
        new Thread(p).start();
        new Thread(c2).start();
    }

}
