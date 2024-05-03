package StackAndQueues;

public class StackUsingArray {
    static int[] stack = new int[5];
    static int top = -1;
    public static void main(String[] args) {

        StackUsingArray stackArr = new StackUsingArray();
        stackArr.push( 59);
        stackArr.push( 45);
        stackArr.pop( );
        stackArr.pop( );
        stackArr.push( 12);
        stackArr.push( 6);
        stackArr.pop( );
        stackArr.push( 32);
        printArray(stack);
        System.out.println("top" + top);

    }

    private void push( int i) throws Error{
        if(top== stack.length-1)
            throw new Error("Stack is full");
        stack[++top] = i ;
    }

    private int pop(){
        if(top==-1)
            throw new Error("stack is empty");
        return stack[top--];
    }

    private static void printArray(int[] arr) {
        // enhanced for loop
        for (int j : arr)
            System.out.println(j);
    }
}
