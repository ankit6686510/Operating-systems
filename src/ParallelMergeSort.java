import java.util.*;
import java.util.concurrent.*;

public class ParallelMergeSort implements Callable<List<Integer>> {
    private List<Integer> array;

    public ParallelMergeSort(List<Integer> array) {
        this.array = array;
    }

    @Override
    public List<Integer> call() throws Exception {
        int size = array.size();

        // Base case
        if (size <= 1) return array;

        int mid = size / 2;
        List<Integer> left = array.subList(0, mid);
        List<Integer> right = array.subList(mid, size);

        ExecutorService executor = Executors.newFixedThreadPool(2); // sort both halves in parallel

        Future<List<Integer>> leftFuture = executor.submit(new ParallelMergeSort(new ArrayList<>(left)));
        Future<List<Integer>> rightFuture = executor.submit(new ParallelMergeSort(new ArrayList<>(right)));

        List<Integer> sortedLeft = leftFuture.get();   // wait for left sort
        List<Integer> sortedRight = rightFuture.get(); // wait for right sort

        executor.shutdown(); // shutdown current executor
        return merge(sortedLeft, sortedRight);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Standard merge logic
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> numbers = Arrays.asList(38, 27, 43, 3, 9, 82, 10);

        ExecutorService mainExecutor = Executors.newSingleThreadExecutor();

        Future<List<Integer>> sortedFuture = mainExecutor.submit(new ParallelMergeSort(numbers));

        List<Integer> sorted = sortedFuture.get(); // wait for result

        System.out.println("Sorted List: " + sorted);

        mainExecutor.shutdown();
    }
}



/*
🔍 What This Demonstrates:
Concept	Used In
Callable<T>---> For recursive sorting tasks
ExecutorService---> To manage threads
Future.get()--->	To block until result is ready
Divide & Conquer + Threads --->	MergeSort done concurrently 

 */