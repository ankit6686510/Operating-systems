import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count(); // count is an object of Count class
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Adder(c ,lock)); // create thread for Adder
        Thread t2 = new Thread(new Subtractor(c ,lock)); // create thread for Subtractor

        t1.start(); // start threads
        t2.start();

        t1.join(); // wait for threads to finish
        t2.join();

        System.out.println("Final value: " + c.getValue());
    }
}
  