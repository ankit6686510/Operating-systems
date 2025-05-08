public class IO_bound_Thread {
    Thread ioBound = new Thread(() -> {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("I/O-bound thread working...");
                Thread.sleep(1000); // Simulates waiting for I/O
            }
            System.out.println("I/O-bound thread done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    
}
//This thread does some work, but frequently waits, simulating I/O like disk read or network call.
/*
🧪 What happens when both run?
 cpuBound.start();
ioBound.start();

 */

/* 
 🕵️‍♂️ Observation:
CPU-bound hogs the processor for computation.

I/O-bound frequently sleeps — giving CPU a chance to run other threads.

In a single-core CPU:

CPU-bound may starve I/O-bound if thread scheduling is unfair.

In multi-core CPU:

Both may run in parallel — better performance.


 */