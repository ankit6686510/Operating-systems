import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Reeentarntlock {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("outer method");
            innermethod();
        }
        finally{
            lock.unlock();
        }
    }
    public void innermethod(){
        lock.lock();
        try{
            System.out.println("inner method");
        }
        finally{
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        Reeentarntlock example  = new Reeentarntlock();
        example.outerMethod();
    }

}
