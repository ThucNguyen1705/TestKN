package hus.oop.datastructure;

import java.util.NoSuchElementException;

public class MyLinkedListQueue implements MyQueue {
    private Node head;
    private Node tail;
    private int numberOfElements;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
        numberOfElements = 0;
    }

    @Override
    public void enqueue(int element) {
        /* TODO */
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        numberOfElements++;
    }

    @Override
    public int dequeue() {
        /* TODO */
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int dequeuedValue = head.data;
        head = head.next;
        if (head == null) {
            tail = null; // If head becomes null, queue is empty, so tail must also be null
        }
        numberOfElements--;
        return dequeuedValue;
    }

    @Override
    public int peek() {
        /* TODO */
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return head == null;
    }

    // Helper method to print queue elements for testing
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: [");
        Node current = head;
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
