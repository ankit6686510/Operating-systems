import java.util.concurrent.*;

public class MyCallable implements Callable<String> {
    //Do something and return a result
    @Override
    public String call() throws Exception {
        return "Hello from Callable! " + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(new MyCallable());

        // Blocking call - waits for result
        String result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}
