package StackAndQueues;

public class queueUsingArray {
    private static int[] queue = new int[5];
    private int head = 0;
    private int tail = -1;

    public static void main(String[] args) {
        try {
            queueUsingArray q = new queueUsingArray();
            q.enqueue(10);
            q.enqueue(20);
            q.dequeue();
            q.dequeue();
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);
            q.dequeue();
            System.out.println(queue[q.head]);
            System.out.println(queue[q.tail]);
        } catch (Error error) {
            System.out.println(error);

        }
    }

    private void enqueue(int i) {

        if (head == queue.length - 1)
            throw new Error("Queue is full");
        if (head == -1)
            head++;
        tail++;
        queue[tail] = i;

    }

    private int dequeue() throws Error {
        if (head == -1 || head == 5)
            throw new Error("No element in queue");
        int element = queue[head];
        head++;
        return element;
    }
}
