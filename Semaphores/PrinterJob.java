import java.util.concurrent.*;

public class PrinterJob implements Runnable {
    private static Semaphore printers = new Semaphore(3); // only 3 printers

    private int jobId;

    public PrinterJob(int id) {
        this.jobId = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Job " + jobId + " waiting to print...");
            printers.acquire();  // Wait for printer
            System.out.println("Job " + jobId + " printing...");
            Thread.sleep(3000);  // Simulate time to print
            System.out.println("Job " + jobId + " finished printing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            printers.release();  // Make printer available
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(new PrinterJob(i)).start();
        }
    }
}
