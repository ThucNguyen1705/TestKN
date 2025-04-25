package hus.oop.datastructure;

import java.util.NoSuchElementException;
import java.util.Arrays;

public class MyArrayQueue implements MyQueue {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    public MyArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayQueue(int capacity) {
        /* TODO */
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        elements = new int[capacity];
        headIndex = 0;
        tailIndex = -1; // Represents an empty queue
        numberOfElements = 0;
    }

    @Override
    public void enqueue(int element) {
        /* TODO */
        if (numberOfElements == elements.length) {
            grow();
        }
        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = element;
        numberOfElements++;
    }

    /*
     * Tăng kích thước queue gấp đôi.
     */
    private void grow() {
        /* TODO */
        int newCapacity = elements.length * 2;
        if (newCapacity > MAX_SIZE) {
            newCapacity = MAX_SIZE;
        }
        int[] newElements = new int[newCapacity];
        for (int i = 0; i < numberOfElements; i++) {
            newElements[i] = elements[(headIndex + i) % elements.length];
        }
        elements = newElements;
        headIndex = 0;
        tailIndex = numberOfElements - 1;
    }

    @Override
    public int dequeue() {
        /* TODO */
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int removedElement = elements[headIndex];
        headIndex = (headIndex + 1) % elements.length;
        numberOfElements--;
        if (isEmpty()) {
            headIndex = 0;
            tailIndex = -1;
        }
        return removedElement;
    }

    @Override
    public int peek() {
        /* TODO */
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[headIndex];
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return numberOfElements == 0;
    }

    // Helper method to print queue elements for testing
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: [");
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(elements[(headIndex + i) % elements.length]);
            if (i < numberOfElements - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
