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
    }
}
