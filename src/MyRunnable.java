public class MyRunnable implements Runnable {
    // Use case: Just run something, no result needed.
    @Override
    public void run() {
        System.out.println("Running from Runnable: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
