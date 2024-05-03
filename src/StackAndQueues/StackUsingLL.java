package StackAndQueues;

import Common.Node;

public class StackUsingLL {
    static Node top = null;

    public static void main(String[] args) {

        StackUsingLL stackArr = new StackUsingLL();
        stackArr.push(59);
        stackArr.push(45);
        stackArr.pop();
        stackArr.pop();
        stackArr.push(12);
        stackArr.push(6);
        stackArr.pop();
        stackArr.push(32);
        printStack(top);
        System.out.println("top - " + top.key);

    }

    private static void printStack(Node top) {
        System.out.println("Remaining stack elements start from top");
        while(top!=null){
            System.out.println(top.key);
            top = top.next;
        }
    }

    private void push(int i) {

        Node node = new Node(i, null);

        if (top == null) {
            top = node;
            return;
        }
        node.next = top;
        top = node;

    }

    private Node pop() throws Error{
        if (top == null)
            throw new Error("Stack Empty");
        else{
            Node node = top;
            top = top.next;
            return node;
        }
    }

}
