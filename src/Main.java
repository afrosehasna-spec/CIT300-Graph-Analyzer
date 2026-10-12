import java.util.*;

/**
 * Main console application: integrates all components.
 */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static final ArrayOperations array = new ArrayOperations(100);
    private static final MyStack stack = new MyStack(10);
    private static final MyQueue queue = new MyQueue(10);
    private static final MyLinkedList list = new MyLinkedList();
    private static final SearchOperations searcher = new SearchOperations();
    private static final Graph graph = new Graph();
    private static final PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    // ---------- input helpers with validation ----------
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static int readChoice(int min, int max) {
        while (true) {
            int c = readInt("Enter your choice: ");
            if (c >= min && c <= max) return c;
            System.out.println("Choice must be between " + min + " and " + max + ".");
        }
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            switch (readChoice(1, 9)) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: listMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceComparison(); break;
                case 8: analyzer.displayAll(); break;
                case 9: running = false; System.out.println("Goodbye!"); break;
            }
        }
    }

    // ---------- Array ----------
    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert (at end)");
            System.out.println("2. Insert at position");
            System.out.println("3. Delete a value");
            System.out.println("4. Search a value");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            switch (readChoice(1, 6)) {
                case 1:
                    if (array.insert(readInt("Enter value: "))) System.out.println("Inserted.");
                    break;
                case 2:
                    int pos = readInt("Enter position (1-based): ");
                    int val = readInt("Enter value: ");
                    if (array.insertAt(pos, val)) System.out.println("Inserted.");
                    break;
                case 3:
                    if (array.delete(readInt("Enter value to delete: "))) System.out.println("Deleted.");
                    break;
                case 4:
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int idx = array.search(readInt("Enter value to search: "));
                    System.out.println(idx == -1 ? "Not found." : "Found at index " + idx);
                    System.out.println("Steps: " + array.getLastSteps());
                    break;
                case 5: array.display(); break;
                case 6: return;
            }
        }
    }

    // ---------- Stack ----------
    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            switch (readChoice(1, 5)) {
                case 1:
                    if (stack.push(readInt("Enter value: "))) System.out.println("Pushed.");
                    break;
                case 2:
                    Integer p = stack.pop();
                    if (p != null) System.out.println("Popped: " + p);
                    break;
                case 3:
                    Integer t = stack.peek();
                    if (t != null) System.out.println("Top: " + t);
                    else System.out.println("Stack is empty.");
                    break;
                case 4: stack.display(); break;
                case 5: return;
            }
        }
    }

    // ---------- Queue ----------
    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            switch (readChoice(1, 5)) {
                case 1:
                    if (queue.enqueue(readInt("Enter value: "))) System.out.println("Enqueued.");
                    break;
                case 2:
                    Integer d = queue.dequeue();
                    if (d != null) System.out.println("Dequeued: " + d);
                    break;
                case 3:
                    Integer f = queue.peek();
                    if (f != null) System.out.println("Front: " + f);
                    else System.out.println("Queue is empty.");
                    break;
                case 4: queue.display(); break;
                case 5: return;
            }
        }
    }

    // ---------- Linked List ----------
    private static void listMenu() {
        while (true) {
            System.out.println("\n----------- LINKED LIST OPERATIONS ----------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            switch (readChoice(1, 6)) {
                case 1: list.insertAtBeginning(readInt("Enter value: ")); System.out.println("Inserted."); break;
                case 2: list.insertAtEnd(readInt("Enter value: ")); System.out.println("Inserted."); break;
                case 3:
                    if (list.isEmpty()) { System.out.println("List is empty."); break; }
                    if (list.delete(readInt("Enter value to delete: "))) System.out.println("Deleted.");
                    else System.out.println("Value not found.");
                    break;
                case 4:
                    if (list.isEmpty()) { System.out.println("List is empty."); break; }
                    int pos = list.search(readInt("Enter value to search: "));
                    System.out.println(pos == -1 ? "Not found." : "Found at position " + pos);
                    System.out.println("Steps: " + list.getLastSteps());
                    analyzer.record("Search", "Linked List Search", list.getLastSteps(), 0);
                    break;
                case 5: list.display(); break;
                case 6: return;
            }
        }
    }

    // ---------- Searching ----------
    private static void searchMenu() {
        while (true) {
            System.out.println("\n------------- SEARCHING OPERATIONS ----------");
            System.out.println("1. Linear Search (on Array component data)");
            System.out.println("2. Binary Search (on Array component data)");
            System.out.println("3. Compare Linear vs Binary (on Array component data)");
            System.out.println("4. Return to Main Menu");
            int c = readChoice(1, 4);
            if (c == 4) return;
            if (array.isEmpty()) {
                System.out.println("Array is empty. Add values in Array Operations first.");
                continue;
            }
            int target = readInt("Enter value to search: ");
            int[] arr = array.toArray();
            if (c == 1) {
                int i = searcher.linearSearch(arr, target);
                System.out.println(i == -1 ? "Not found." : "Found at index " + i);
                System.out.println("Steps: " + searcher.getLastSteps() + " | Time: " + searcher.getLastTimeNanos() + " ns");
                analyzer.record("Search", "Linear Search", searcher.getLastSteps(), searcher.getLastTimeNanos());
            } else if (c == 2) {
                if (!SearchOperations.isSorted(arr)) {
                    System.out.println("Array is not sorted. Binary search needs sorted data.");
                    System.out.print("Sort the array now? (y/n): ");
                    if (sc.nextLine().trim().equalsIgnoreCase("y")) {
                        array.sort();
                        arr = array.toArray();
                        System.out.println("Array sorted.");
                    } else continue;
                }
                int i = searcher.binarySearch(arr, target);
                System.out.println(i == -1 ? "Not found." : "Found at index " + i);
                System.out.println("Steps: " + searcher.getLastSteps() + " | Time: " + searcher.getLastTimeNanos() + " ns");
                analyzer.record("Search", "Binary Search", searcher.getLastSteps(), searcher.getLastTimeNanos());
            } else {
                searcher.compare(arr, target, analyzer);
            }
        }
    }

    // ---------- Graph ----------
    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            switch (readChoice(1, 6)) {
                case 1:
                    if (graph.addVertex(readInt("Enter vertex number: "))) System.out.println("Vertex added.");
                    break;
                case 2:
                    int a = readInt("Enter first vertex: ");
                    int b = readInt("Enter second vertex: ");
                    if (graph.addEdge(a, b)) System.out.println("Edge added.");
                    break;
                case 3: graph.display(); break;
                case 4:
                    if (graph.isEmpty()) { System.out.println("Graph is empty."); break; }
                    List<Integer> bf = graph.bfs(readInt("Enter start vertex: "));
                    if (!bf.isEmpty()) {
                        System.out.println("BFS order: " + bf + " | Steps: " + graph.getLastSteps());
                        analyzer.record("Graph Traversal", "BFS", graph.getLastSteps(), graph.getLastTimeNanos());
                    }
                    break;
                case 5:
                    if (graph.isEmpty()) { System.out.println("Graph is empty."); break; }
                    List<Integer> df = graph.dfs(readInt("Enter start vertex: "));
                    if (!df.isEmpty()) {
                        System.out.println("DFS order: " + df + " | Steps: " + graph.getLastSteps());
                        analyzer.record("Graph Traversal", "DFS", graph.getLastSteps(), graph.getLastTimeNanos());
                    }
                    break;
                case 6: return;
            }
        }
    }

    // ---------- Performance Comparison ----------
    private static void performanceComparison() {
        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON (automatic demo)");
        System.out.println("=============================================");

        // Search demo: sorted array of 10,000 numbers, target is near the end
        int n = 10000;
        int[] big = new int[n];
        for (int i = 0; i < n; i++) big[i] = i * 2;
        int target = big[n - 1];
        System.out.println("Demo array: " + n + " sorted elements, target = " + target);
        searcher.compare(big, target, analyzer);

        // Graph demo: use user's graph, or build a sample graph
        Graph g = graph;
        if (graph.isEmpty()) {
            System.out.println("\nYour graph is empty, so a sample graph (vertices 1-6) is used.");
            g = new Graph();
            for (int v = 1; v <= 6; v++) g.addVertex(v);
            g.addEdge(1, 2); g.addEdge(1, 3); g.addEdge(2, 4);
            g.addEdge(3, 5); g.addEdge(4, 6); g.addEdge(5, 6);
            g.display();
        }
        int start = g.isEmpty() ? 1 : g.bfsStartVertex();
        g.bfs(start);
        analyzer.record("Graph Traversal", "BFS", g.getLastSteps(), g.getLastTimeNanos());
        g.dfs(start);
        analyzer.record("Graph Traversal", "DFS", g.getLastSteps(), g.getLastTimeNanos());

        System.out.println();
        analyzer.displayAll();
        System.out.println("\nWhy results differ:");
        System.out.println("- Linear search is O(n); binary search is O(log n), so it needs far fewer steps.");
        System.out.println("- BFS and DFS are both O(V + E); step counts are usually equal, order of visiting differs.");
    }
}
