public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();// shared data between producer and consumer

        Thread t1 =  new Thread(new Producer(shop));// producer thread
        Thread t2 =  new Thread(new Consumer(shop));// consumer thread

        t1.start(); // start producer thread
        t2.start(); // start consumer thread
        
    }
}
