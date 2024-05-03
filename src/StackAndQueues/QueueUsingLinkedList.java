package StackAndQueues;

import Common.Node;

import java.util.*;

public class QueueUsingLinkedList {
    static Node head = null;
    static Node tail = null;

    public static void main(String[] args) {
        try {
            QueueUsingLinkedList q = new QueueUsingLinkedList();
            q.enqueue(10);
            q.enqueue(20);
            q.dequeue();
            q.dequeue();
            q.enqueue(30);
            q.enqueue(40);
            q.enqueue(50);
            q.dequeue();
        } catch (Error error) {
            System.out.println(error);

        }
    }

    private void enqueue(int i) {
        Node newNode = new Node(i, null);

        if (head == null) { //0 elemets
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    private Node dequeue() throws Error {
        if (head == null) //0 elements in queue
            throw new Error("Queue is empty");
        Node res = head;
        if (head == tail) //Only 1 element present in queue
            tail = tail.next;
        head = head.next;

        return res;

    }
}
