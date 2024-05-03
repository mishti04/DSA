package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class JavaDequeAsStack {
    public static void main(String[] args) {

        //We can use any implentation of Deque which are ArrayDeque or Linked list
        //there is another implementation that Java provides which is stack but
        //Java suggests using Deque as stack rather than stack itself
        //as stack is synchronised in nature

        Deque<Integer> stack = new ArrayDeque<>();
        // Deque<Integer> stack = new LinkedList<>();

        stack.addFirst(45);
        stack.addFirst(1);
        stack.removeFirst();
        stack.addFirst(52);
        stack.addFirst(33);
        stack.removeFirst();

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

}
