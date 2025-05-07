import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit 100 tasks to the thread pool
        for (int i = 1; i <= 100; i++) {
            int number = i;  // need final or effectively final variable in lambda
            executor.submit(() -> {
                System.out.println("Printing " + number + " from " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();  // shuts down after completing all tasks
    }
}
