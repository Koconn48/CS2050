//Name: Kevin O'Connell
//Assignment: Program #4 - Linked Lists
import java.util.EmptyStackException;
public class MyLinkedStack {
    private Node top;
    private int maxSize;
    private int size;
    // constructor for stack with size N
    public MyLinkedStack(int N) {
        maxSize = N;
        top = null;
        size = 0;
    }
    // push
    public void push(char value) {
        if (size < maxSize) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            size++;
        } else {
            System.out.println("Stack is full, can not push.");
        }
    }
    // peek and return
    public char peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            throw new EmptyStackException();
        }
    }
    // pop and return
    public char pop() {
        if (!isEmpty()) {
            char value = top.data;
            top = top.next;
            size--;
            return value;
        } else {
            throw new EmptyStackException();
        }
    }
    public boolean isEmpty() {
        return top == null;
    } // check if stack is empty
    public int size() {
        return size;  // Return the size
    } // total number of elements in the stack

    private class Node {
        char data;
        Node next;
        // constructor for node
        Node(char value) {
            data = value;
            next = null;
        }
    }
}
