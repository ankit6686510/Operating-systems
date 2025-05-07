public class PrintNumber implements Runnable {
    private int numbertoprint;

    public PrintNumber(int numbertoprint) {
        this.numbertoprint = numbertoprint;
    }

    @Override
    public void run() {
        System.out.println(numbertoprint + " " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            PrintNumber np = new PrintNumber(i); 
            Thread t = new Thread(np);
            t.start();
        }
    }
}
