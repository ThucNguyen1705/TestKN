package hus.oop.datastructure;

import java.util.EmptyStackException;

/**
 * Stack sử dụng cấu trúc dữ liệu linked list.
 */
public class MyLinkedListStack implements MyStack {
    private Node top;
    private int numberOfElements;

    public MyLinkedListStack() {
        top = null;
        numberOfElements = 0;
    }

    @Override
    public void push(int value) {
        /* TODO */
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        numberOfElements++;
    }

    @Override
    public int pop() {
        /* TODO */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = top.data;
        top = top.next;
        numberOfElements--;
        return poppedValue;
    }

    @Override
    public int peek() {
        /* TODO */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return top == null;
    }

    // Helper method to print stack elements for testing
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: [");
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}
