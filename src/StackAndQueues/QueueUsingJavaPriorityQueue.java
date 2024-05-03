package StackAndQueues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueUsingJavaPriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(555);
        pq.add(59);
        pq.remove();
        pq.add(99);
        pq.remove();
        pq.add(522);
        pq.add(22);
        pq.remove();

        Iterator<Integer> itr =  pq.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
