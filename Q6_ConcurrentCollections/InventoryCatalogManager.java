import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ConcurrentHashMap;
public class InventoryCatalogManager {

    private static final int TOTAL_OPERATIONS = 50000;
    private static final int WORKER_THREADS = 10;

    private final Map<String, Integer> productStock = new HashMap<>();

    public InventoryCatalogManager() {
        for (int i = 1; i <= 1000; i++) {
            productStock.put("P" + i, 100);
        }
    }
    public void benchmarkSynchronizedMap() throws InterruptedException {

    Map<String, Integer> synchronizedStock =
            Collections.synchronizedMap(new HashMap<>(productStock));

    ExecutorService executor = Executors.newFixedThreadPool(WORKER_THREADS);

    long startTime = System.nanoTime();

    for (int i = 0; i < TOTAL_OPERATIONS; i++) {
        final int operation = i;

        executor.submit(() -> {
            String productId = "P" + ((operation % 1000) + 1);

            Integer stock = synchronizedStock.get(productId);

            if (stock != null) {
                synchronizedStock.put(productId, stock - 1);
            }
        });
    }

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.HOURS);

    long endTime = System.nanoTime();

    double elapsedSeconds = (endTime - startTime) / 1_000_000_000.0;
    double throughput = TOTAL_OPERATIONS / elapsedSeconds;

    System.out.println("\nSynchronizedMap Benchmark");
    System.out.println("Execution time: "
            + elapsedSeconds * 1000 + " ms");
    System.out.println("Throughput: "
            + throughput + " operations/second");
}
public void benchmarkConcurrentMap() throws InterruptedException {

    Map<String, Integer> concurrentStock =
            new ConcurrentHashMap<>(productStock);

    ExecutorService executor = Executors.newFixedThreadPool(WORKER_THREADS);

    long startTime = System.nanoTime();

    for (int i = 0; i < TOTAL_OPERATIONS; i++) {
        final int operation = i;

        executor.submit(() -> {
            String productId = "P" + ((operation % 1000) + 1);

            concurrentStock.computeIfPresent(
                    productId, (key, stock) -> stock - 1
            );
        });
    }

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.HOURS);

    long endTime = System.nanoTime();

    double elapsedSeconds = (endTime - startTime) / 1_000_000_000.0;
    double throughput = TOTAL_OPERATIONS / elapsedSeconds;

    System.out.println("\nConcurrentHashMap Benchmark");
    System.out.println("Execution time: "
            + elapsedSeconds * 1000 + " ms");
    System.out.println("Throughput: "
            + throughput + " operations/second");
}
public static void main(String[] args) throws InterruptedException {

    InventoryCatalogManager manager = new InventoryCatalogManager();

    System.out.println("Inventory Catalog Concurrency Benchmark");
    System.out.println("Products initialized: " + manager.productStock.size());
    System.out.println("Worker threads: " + WORKER_THREADS);
    System.out.println("Total operations: " + TOTAL_OPERATIONS);

    manager.benchmarkSynchronizedMap();
    manager.benchmarkConcurrentMap();
}
}