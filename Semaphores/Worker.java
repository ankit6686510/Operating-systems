import java.util.concurrent.Semaphore;

//Limiting access with 2 permits

public class Worker implements Runnable {
    private Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " waiting for permit...");
            semaphore.acquire();  // ⛔ Waits if no permit available
            System.out.println(Thread.currentThread().getName() + " got permit ✅");

            Thread.sleep(2000);  // Simulate work

            System.out.println(Thread.currentThread().getName() + " releasing permit...");
            semaphore.release();  // ✅ Give permit back
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
