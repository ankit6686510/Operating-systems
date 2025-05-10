import java.util.concurrent.*;

class Task implements Runnable {
    private final int taskId;
    private final Semaphore semaphore;

    public Task(int id, Semaphore semaphore) {
        this.taskId = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();  // acquire permit before executing
            System.out.println("Task " + taskId + " is running by " + Thread.currentThread().getName());
            Thread.sleep(2000);   // simulate task time
            System.out.println("Task " + taskId + " finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();  // release permit
        }
    }
     public static void main(String[] args) {
        int maxThreads = 3;
        Semaphore semaphore = new Semaphore(maxThreads); // only 3 concurrent tasks

        ExecutorService executor = Executors.newFixedThreadPool(10); // actual pool

        for (int i = 1; i <= 10; i++) {
            executor.submit(new Task(i, semaphore));
        }

        executor.shutdown();
    }
}

/* 
 What's Happening:
We submit 10 tasks using a 10-thread executor.

But due to Semaphore(3), only 3 tasks can run at the same time.

Others wait until a permit is released. 
*/
