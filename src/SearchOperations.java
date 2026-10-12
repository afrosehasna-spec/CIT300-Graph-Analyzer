/**
 * Searching component: Linear Search and Binary Search with step counting and timing.
 */
public class SearchOperations {
    private long lastSteps;
    private long lastTimeNanos;

    public long getLastSteps() { return lastSteps; }
    public long getLastTimeNanos() { return lastTimeNanos; }

    /** Linear search: works on any array. O(n). Returns index or -1. */
    public int linearSearch(int[] arr, int target) {
        lastSteps = 0;
        long start = System.nanoTime();
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            lastSteps++;
            if (arr[i] == target) { result = i; break; }
        }
        lastTimeNanos = System.nanoTime() - start;
        return result;
    }

    /** Binary search: array MUST be sorted. O(log n). Returns index or -1. */
    public int binarySearch(int[] arr, int target) {
        lastSteps = 0;
        long start = System.nanoTime();
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            lastSteps++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) { result = mid; break; }
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        lastTimeNanos = System.nanoTime() - start;
        return result;
    }

    /** Checks whether an array is sorted ascending. */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    /** Runs both searches on the same data, prints comparison and records results. */
    public void compare(int[] arr, int target, PerformanceAnalyzer analyzer) {
        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);   // binary search needs sorted data

        int li = linearSearch(sorted, target);
        long lSteps = lastSteps, lTime = lastTimeNanos;
        int bi = binarySearch(sorted, target);
        long bSteps = lastSteps, bTime = lastTimeNanos;

        System.out.println("Searching for " + target + " in sorted array of " + sorted.length + " elements");
        System.out.println("Linear Search : " + (li == -1 ? "not found" : "found at index " + li)
                + " | steps = " + lSteps + " | time = " + lTime + " ns");
        System.out.println("Binary Search : " + (bi == -1 ? "not found" : "found at index " + bi)
                + " | steps = " + bSteps + " | time = " + bTime + " ns");
        System.out.println("Linear is O(n), Binary is O(log n), so binary needs far fewer steps on large data.");

        analyzer.record("Search", "Linear Search", lSteps, lTime);
        analyzer.record("Search", "Binary Search", bSteps, bTime);
    }
}