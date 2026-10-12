
public class MyQueue {
    private final int[] items;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity must be positive."
            );
        }
        items = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enqueue(int value) {
        if (size == items.length) {
            System.out.println("Queue is full.");
            return false;
        }
        items[rear] = value;
        rear = (rear + 1) % items.length;
        size++;
        return true;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        int value = items[front];
        front = (front + 1) % items.length;
        size--;
        return value;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return items[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(items[(front + i) % items.length] + " ");
        }
        System.out.println();
    }
}