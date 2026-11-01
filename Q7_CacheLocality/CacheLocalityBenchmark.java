
public class CacheLocalityBenchmark {

    public static void main(String[] args) {
        int size = 2000;
        int[][] matrix = new int[size][size];
        
        
long start = System.nanoTime();

for (int k = 0; k < 10; k++) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            matrix[i][j]++;
        }
    }
}

long rowTime = System.nanoTime() - start;
System.out.println("Row-major time: " + rowTime / 1e6 + " ms");

        System.out.println("Cache Locality Benchmark");
        System.out.println("Matrix size: " + size + " x " + size);
    
start = System.nanoTime();

for (int k = 0; k < 10; k++) {
    for (int j = 0; j < size; j++) {
        for (int i = 0; i < size; i++) {
            matrix[i][j]++;
        }
    }
}

long colTime = System.nanoTime() - start;

System.out.println("Column-major time: " + colTime / 1e6 + " ms");
System.out.println("Speedup: " + (double) colTime / rowTime + "x");

    }
}
