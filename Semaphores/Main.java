import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);  // Only 2 threads allowed at once

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Worker(semaphore), "Thread-" + i);
            t.start();
        }
    }
}
