import java.util.ArrayList;
import java.util.List;

/**
 * Collects performance results (operation, algorithm, steps, time)
 * from the other components and displays them as a table.
 */
public class PerformanceAnalyzer {

    /** One recorded result. */
    private static class Result {
        final String operation;
        final String algorithm;
        final long steps;
        final long timeNanos;

        Result(String operation, String algorithm, long steps, long timeNanos) {
            this.operation = operation;
            this.algorithm = algorithm;
            this.steps = steps;
            this.timeNanos = timeNanos;
        }
    }

    private final List<Result> results = new ArrayList<>();

    /** Stores one result. */
    public void record(String operation, String algorithm, long steps, long timeNanos) {
        results.add(new Result(operation, algorithm, steps, timeNanos));
    }

    public boolean hasResults() {
        return !results.isEmpty();
    }

    /** Prints all stored results in a table. */
    public void displayAll() {
        System.out.println("=============================================");
        System.out.println(" PERFORMANCE COMPARISON / ALL RESULTS");
        System.out.println("=============================================");
        if (results.isEmpty()) {
            System.out.println("No results recorded yet. Run searches or graph traversals first.");
            return;
        }
        System.out.printf("%-17s %-20s %-10s %s%n", "Operation", "Algorithm", "Steps", "Time(ns)");
        System.out.println("------------------------------------------------------------");
        for (Result r : results) {
            System.out.printf("%-17s %-20s %-10d %d%n", r.operation, r.algorithm, r.steps, r.timeNanos);
        }
        System.out.println("=============================================");
    }
}
