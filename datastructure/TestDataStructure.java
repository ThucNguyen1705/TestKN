package hus.oop.datastructure;

import java.util.Random;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class TestDataStructure {
    public static void main(String[] args) {
        /* TODO
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_DataStructure>.txt (Ví dụ, NguyenVanA_123456_DataStructure.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_DataStructure>.zip (Ví dụ, NguyenVanA_123456_DataStructure.zip),
          nộp lên classroom.
        */

        System.out.println("--- Test Array Stack ---");
        testArrayStack();
        System.out.println("\n--- Test Linked List Stack ---");
        testLinkedListStack();
        System.out.println("\n--- Test Array Queue ---");
        testArrayQueue();
        System.out.println("\n--- Test Linked List Queue ---");
        testLinkedListQueue();
    }

    public static void testArrayStack() {
        /* TODO
         - Sinh ngẫu nhiên ra một số tự nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        Random random = new Random();
        int n = random.nextInt(11) + 20;
        MyArrayStack stack = new MyArrayStack();
        System.out.println("Pushing " + n + " random integers onto Array Stack:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Random integers between 0 and 99
            stack.push(value);
        }

        System.out.print("Elements in stack after pushing: ");
        stack.printStack();

        System.out.println("Popping elements from stack:");
        while (!stack.isEmpty()) {
            try {
                int poppedValue = stack.pop();
                System.out.println("Popped: " + poppedValue);
                System.out.print("Elements remaining: ");
                stack.printStack();
            } catch (EmptyStackException e) {
                System.out.println("Stack is empty.");
            }
        }
    }

    public static void testLinkedListStack() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.
         */
        Random random = new Random();
        int n = random.nextInt(11) + 20; // n in [20, 30]

        MyLinkedListStack stack = new MyLinkedListStack();
        System.out.println("Pushing " + n + " random integers onto Linked List Stack:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Random integers between 0 and 99
            stack.push(value);
        }

        System.out.print("Elements in stack after pushing: ");
        stack.printStack();

        System.out.println("Popping elements from stack:");
        while (!stack.isEmpty()) {
            try {
                int poppedValue = stack.pop();
                System.out.println("Popped: " + poppedValue);
                System.out.print("Elements remaining: ");
                stack.printStack();
            } catch (EmptyStackException e) {
                System.out.println("Stack is empty.");
            }
        }
    }

    public static void testArrayQueue() {
        /* TODO
         - Sinh ngẫu nhiên ra một số tự nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */
        Random random = new Random();
        int n = random.nextInt(11) + 20; // n in [20, 30]

        MyArrayQueue queue = new MyArrayQueue();
        System.out.println("Enqueuing " + n + " random integers onto Array Queue:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Random integers between 0 and 99
            queue.enqueue(value);
        }

        System.out.print("Elements in queue after enqueuing: ");
        queue.printQueue();

        System.out.println("Dequeuing elements from queue:");
        while (!queue.isEmpty()) {
            try {
                int dequeuedValue = queue.dequeue();
                System.out.println("Dequeued: " + dequeuedValue);
                System.out.print("Elements remaining: ");
                queue.printQueue();
            } catch (NoSuchElementException e) {
                System.out.println("Queue is empty.");
            }
        }
    }

    public static void testLinkedListQueue() {
        /* TODO
         - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [20 - 30], gọi là n.
         - Sinh ngẫu nhiên ra n số nguyên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
         */
        Random random = new Random();
        int n = random.nextInt(11) + 20; // n in [20, 30]

        MyLinkedListQueue queue = new MyLinkedListQueue();
        System.out.println("Enqueuing " + n + " random integers onto Linked List Queue:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); 
            queue.enqueue(value);
        }

        System.out.print("Elements in queue after enqueuing: ");
        queue.printQueue();

        System.out.println("Dequeuing elements from queue:");
        while (!queue.isEmpty()) {
            try {
                int dequeuedValue = queue.dequeue();
                System.out.println("Dequeued: " + dequeuedValue);
                System.out.print("Elements remaining: ");
                queue.printQueue();
            } catch (NoSuchElementException e) {
                System.out.println("Queue is empty.");
            }
        }
    }
}
