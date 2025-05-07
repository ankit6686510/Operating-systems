public class HelloWorldThread implements Runnable {
    public static void main(String[] args) {
        System.out.println("Hello World! " + Thread.currentThread().getName());

        HelloWorldThread hwt = new HelloWorldThread();  // implements Runnable
        Thread t = new Thread(hwt);  // pass Runnable to Thread
        t.start();

        System.out.println("Hello World! " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Hello from new thread: " + Thread.currentThread().getName());
    }
}
