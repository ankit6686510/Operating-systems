🔧 Types of Thread Pools in Java
You can create different types with Executors:
Executors.newFixedThreadPool(5);      // Fixed number of threads
Executors.newCachedThreadPool();      // Creates new threads as needed, reuses old ones
Executors.newSingleThreadExecutor();  // Only one thread
Executors.newScheduledThreadPool(3);  // For scheduled/delayed tasks
