package hus.oop.datastructure;

import java.util.EmptyStackException;
import java.util.Arrays;

/**
 * Stack sử dụng cấu trúc dữ liệu mảng.
 */
public class MyArrayStack implements MyStack {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int numberOfElements; // Represents the index of the top element + 1

    public MyArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayStack(int initialCapacity) {
        /* TODO */
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    @Override
    public void push(int value) {
        /* TODO */
        if (numberOfElements == elements.length) {
            grow();
        }
        elements[numberOfElements] = value;
        numberOfElements++;
    }

    /*
     * Tăng kích thước stack lên gấp đôi.
     */
    private void grow() {
        /* TODO */
        int newCapacity = elements.length * 2;
        if (newCapacity > MAX_SIZE) {
            newCapacity = MAX_SIZE;
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public int pop() {
        /* TODO */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = elements[numberOfElements - 1];
        numberOfElements--;
        return poppedValue;
    }

    @Override
    public int peek() {
        /* TODO */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[numberOfElements - 1];
    }

    @Override
    public boolean isEmpty() {
        /* TODO */
        return numberOfElements == 0;
    }

    // Helper method to print stack elements for testing
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: [");
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(elements[i]);
            if (i < numberOfElements - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
