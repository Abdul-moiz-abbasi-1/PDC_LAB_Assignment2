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

    }
}
