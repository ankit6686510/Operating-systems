public class CPU_bound_thread {
    Thread cpuBound = new Thread(() -> {
        long sum = 0;
        for (long i = 0; i < 1_000_000_000L; i++) {
            sum += i;
        }
        System.out.println("CPU-bound thread done: " + sum);
    });
    
    
}
//This thread performs intensive calculations. It’s always using the CPU, and doesn’t wait.