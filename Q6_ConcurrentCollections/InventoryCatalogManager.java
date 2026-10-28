import java.util.HashMap;
import java.util.Map;

public class InventoryCatalogManager {

    private static final int TOTAL_OPERATIONS = 50000;
    private static final int WORKER_THREADS = 10;

    private final Map<String, Integer> productStock = new HashMap<>();

    public InventoryCatalogManager() {
        for (int i = 1; i <= 1000; i++) {
            productStock.put("P" + i, 100);
        }
    }

    public static void main(String[] args) {

        InventoryCatalogManager manager = new InventoryCatalogManager();

        System.out.println("Inventory Catalog Concurrency Benchmark");
        System.out.println("Products initialized: " + manager.productStock.size());
        System.out.println("Worker threads: " + WORKER_THREADS);
        System.out.println("Total operations: " + TOTAL_OPERATIONS);

    }
}