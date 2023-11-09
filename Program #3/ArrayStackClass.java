//Name: Kevin O'Connell
//Assignment: Program #3 Stacks - Infix to Postfix
import java.util.EmptyStackException;
class ArrayStackClass {
    private char[] stack;
    private int top; // index of the top element
    private int maxSize;

    // constructor for stack of N elements
    public ArrayStackClass(int N) {
        maxSize = N;
        stack = new char[maxSize]; // Initialize the stack
        top = -1; // Initialize top to -1 (empty stack)
    }
    // push
    public void push(char value) {
        if (top < maxSize - 1) {
            stack[++top] = value;
        } else {
            System.out.println("Stack is full, can not push");
        }
    }
    // pop and return
    public char pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            throw new EmptyStackException();
        }
    }
    // peek and return
    public char peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            throw new EmptyStackException();
        }
    }
    // check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    // total number of elements in the stack
    public int size() {
        return top + 1;
    }
}
