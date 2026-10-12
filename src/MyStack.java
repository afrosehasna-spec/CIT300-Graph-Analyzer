
public class MyStack {
    private final int[] items;
    private int top;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "Capacity must be positive."
            );
        }
        items = new int[capacity];
        top = -1;
    }

    public boolean push(int value) {
        if (top == items.length - 1) {
            System.out.println("Stack is full.");
            return false;
        }
        items[++top] = value;
        return true;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return items[top--];
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return items[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}