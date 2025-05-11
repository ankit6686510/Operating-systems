public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count(); // count is an object of Count class

        Thread t1 = new Thread(new Adder(c)); // create thread for Adder
        Thread t2 = new Thread(new Subtractor(c)); // create thread for Subtractor

        t1.start(); // start threads
        t2.start();

        t1.join(); // wait for threads to finish
        t2.join();

        System.out.println("Final value: " + c.value);
    }
}
  