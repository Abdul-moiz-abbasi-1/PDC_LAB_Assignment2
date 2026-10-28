import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {

    public static void main(String[] args) {
    
        int size = 10000;

double[] risks = new double[size];
double[] assets = new double[size];

for (int i = 0; i < size; i++) {
    risks[i] = (i % 100) + 1;
    assets[i] = (i % 10000) + 1;
}

long serialStart = System.nanoTime();

double serialTotal = 0;

for (int i = 0; i < size; i++) {
    serialTotal += risks[i];
}

long serialEnd = System.nanoTime();

System.out.println("Serial risk total: " + serialTotal);
System.out.println("Serial execution time: "
        + (serialEnd - serialStart) / 1_000_000.0 + " ms");

ForkJoinPool pool = new ForkJoinPool();

long parallelStart = System.nanoTime();

double parallelTotal = pool.invoke(
        new ParallelRiskCalculator(risks, 0, size)
);

long parallelEnd = System.nanoTime();

System.out.println("Parallel risk total: " + parallelTotal);
System.out.println("Parallel execution time: "
        + (parallelEnd - parallelStart) / 1_000_000.0 + " ms");

pool.shutdown();

System.out.println("Risk totals match: "
        + (Math.abs(serialTotal - parallelTotal) < 0.000001));
double cap = 5000.0;

ForkJoinPool thresholdPool = new ForkJoinPool();

long adjustmentStart = System.nanoTime();

thresholdPool.invoke(
        new PortfolioThresholdTask(assets, 0, size, cap)
);

long adjustmentEnd = System.nanoTime();

System.out.println("Portfolio threshold adjustment completed.");
System.out.println("Assets adjusted: "
        + (adjustmentEnd - adjustmentStart) / 1_000_000.0 + " ms");

thresholdPool.shutdown();
    }
}
