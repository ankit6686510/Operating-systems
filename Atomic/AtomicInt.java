public class AtomicInt(
    AtomicInteger count = new AtomicInteger(0);

// Atomically increments and returns the updated value
int newValue = count.incrementAndGet();

// Atomically adds 5
count.addAndGet(5);

// Atomically compares and sets
count.compareAndSet(10, 20); // if current value is 10, set it to 20
)
//AtomicLong — same as AtomicInteger but for long

//  AtomicBoolean
AtomicBoolean flag = new AtomicBoolean(false);

// Atomically sets to true if currently false
flag.compareAndSet(false, true);

// Get the current value
boolean current = flag.get();


/*
 AtomicReference<String> atomicName = new AtomicReference<>("Ankit");

// Atomically update value if old value matches
atomicName.compareAndSet("Ankit", "Bro");

 */


 /*
 compareAndSet() — The Heart of Atomicity
  boolean success = atomicInt.compareAndSet(expectedValue, newValue);

  */