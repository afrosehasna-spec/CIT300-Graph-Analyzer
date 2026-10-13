/**
 * Singly linked list of int values with its own Node class.
 * insertAtBeginning is O(1); insertAtEnd, delete and search are O(n).
 */
public class MyLinkedList {

    /** One node of the list: a value and a link to the next node. */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;      // first node, null when the list is empty
    private int lastSteps;  // nodes checked in the most recent search

    public boolean isEmpty() { return head == null; }

    public int getLastSteps() { return lastSteps; }

    /** Adds a new node at the start. O(1). */
    public void insertAtBeginning(int x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
    }

    /** Adds a new node at the end. O(n) because we walk to the last node. */
    public void insertAtEnd(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    /** Deletes the first node holding x. Returns false if not found or list empty. O(n). */
    public boolean delete(int x) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return false;
        }
        if (head.data == x) {          // deleting the first node
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != x) {
            current = current.next;
        }
        if (current.next == null) {
            return false;              // value not found
        }
        current.next = current.next.next;   // skip over the deleted node
        return true;
    }

    /** Returns the 1-based position of x, or -1 if not found. O(n). */
    public int search(int x) {
        lastSteps = 0;
        Node current = head;
        int position = 1;
        while (current != null) {
            lastSteps++;
            if (current.data == x) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    /** Prints the list like: 10 -> 20 -> 30 -> null */
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb);
    }
}
