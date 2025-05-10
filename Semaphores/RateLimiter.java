import java.util.concurrent.*;

public class RateLimiter implements Runnable {
    private static Semaphore semaphore = new Semaphore(10); // max 10 calls per second

    @Override
    public void run() {
        if (semaphore.tryAcquire()) {
            try {
                System.out.println(Thread.currentThread().getName() + " calling API...");
                Thread.sleep(200);  // Simulate API call
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " blocked due to rate limit.");
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            executor.submit(new RateLimiter());
        }

        executor.shutdown();
    }
}
