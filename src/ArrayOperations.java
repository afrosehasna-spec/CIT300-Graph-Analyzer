/**
 * Array component: fixed-capacity integer array with insert, delete, search, display.
 */
public class ArrayOperations {
    private final int[] data;
    private int size;
    private int lastSteps;

    public ArrayOperations(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }
    public int getSize() { return size; }
    public int getLastSteps() { return lastSteps; }

    /** Insert at end. O(1). */
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Array is full. Cannot insert.");
            return false;
        }
        data[size++] = value;
        return true;
    }

    /** Insert at a position (1-based). Shifts elements right. O(n). */
    public boolean insertAt(int position, int value) {
        if (isFull()) {
            System.out.println("Array is full. Cannot insert.");
            return false;
        }
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Valid range: 1 to " + (size + 1));
            return false;
        }
        for (int i = size; i >= position; i--) {
            data[i] = data[i - 1];
        }
        data[position - 1] = value;
        size++;
        return true;
    }

    /** Delete first occurrence of value. Shifts elements left. O(n). */
    public boolean delete(int value) {
        if (isEmpty()) {
            System.out.println("Array is empty. Nothing to delete.");
            return false;
        }
        int index = search(value);
        if (index == -1) {
            System.out.println("Value " + value + " not found.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Linear search. Returns index (0-based) or -1. O(n). */
    public int search(int value) {
        lastSteps = 0;
        for (int i = 0; i < size; i++) {
            lastSteps++;
            if (data[i] == value) return i;
        }
        return -1;
    }

    /** Sort using insertion sort (needed before binary search). */
    public void sort() {
        for (int i = 1; i < size; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    /** Returns a copy of the used part of the array. */
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]  (size " + size + "/" + data.length + ")");
        System.out.println(sb);
    }
}