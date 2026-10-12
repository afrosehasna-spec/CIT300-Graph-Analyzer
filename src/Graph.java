import java.util.*;

/**
 * Graph component: undirected graph using an adjacency list.
 * BFS and DFS return the number of steps (vertices visited + edges examined).
 */
public class Graph {
    private final Map<Integer, List<Integer>> adjList = new LinkedHashMap<>();
    private long lastSteps;
    private long lastTimeNanos;

    public long getLastSteps() { return lastSteps; }
    public long getLastTimeNanos() { return lastTimeNanos; }
    public boolean isEmpty() { return adjList.isEmpty(); }
    public boolean hasVertex(int v) { return adjList.containsKey(v); }
    public int bfsStartVertex() { return adjList.keySet().iterator().next(); }
    public int vertexCount() { return adjList.size(); }

    public boolean addVertex(int v) {
        if (adjList.containsKey(v)) {
            System.out.println("Vertex " + v + " already exists.");
            return false;
        }
        adjList.put(v, new ArrayList<>());
        return true;
    }

    public boolean addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) {
            System.out.println("Both vertices must exist first.");
            return false;
        }
        if (a == b) {
            System.out.println("Self-loops are not allowed.");
            return false;
        }
        if (adjList.get(a).contains(b)) {
            System.out.println("Edge " + a + " - " + b + " already exists.");
            return false;
        }
        adjList.get(a).add(b);
        adjList.get(b).add(a);
        return true;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** Breadth First Search using a queue. O(V + E). */
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        lastSteps = 0;
        if (!hasVertex(start)) {
            System.out.println("Start vertex not found.");
            return order;
        }
        long t0 = System.nanoTime();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);
            lastSteps++;                       // visiting a vertex
            for (int n : adjList.get(v)) {
                lastSteps++;                   // examining an edge
                if (visited.add(n)) queue.add(n);
            }
        }
        lastTimeNanos = System.nanoTime() - t0;
        return order;
    }

    /** Depth First Search using recursion. O(V + E). */
    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        lastSteps = 0;
        if (!hasVertex(start)) {
            System.out.println("Start vertex not found.");
            return order;
        }
        long t0 = System.nanoTime();
        dfsVisit(start, new HashSet<>(), order);
        lastTimeNanos = System.nanoTime() - t0;
        return order;
    }

    private void dfsVisit(int v, Set<Integer> visited, List<Integer> order) {
        visited.add(v);
        order.add(v);
        lastSteps++;                           // visiting a vertex
        for (int n : adjList.get(v)) {
            lastSteps++;                       // examining an edge
            if (!visited.contains(n)) dfsVisit(n, visited, order);
        }
    }
}
