import java.util.concurrent.RecursiveAction;

public class PortfolioThresholdTask extends RecursiveAction {
private double[] assets;
private int start;
private int end;
private double cap;

private static final int THRESHOLD = 1000;

public PortfolioThresholdTask(double[] assets, int start, int end, double cap) {
    this.assets = assets;
    this.start = start;
    this.end = end;
    this.cap = cap;
}
@Override
protected void compute() {
    if (end - start <= THRESHOLD) {
        for (int i = start; i < end; i++) {
            if (assets[i] > cap) {
                assets[i] = assets[i] * 1.05;
            }
        }
        return;
    }
    int middle = (start + end) / 2;

PortfolioThresholdTask leftTask =
        new PortfolioThresholdTask(assets, start, middle, cap);

PortfolioThresholdTask rightTask =
        new PortfolioThresholdTask(assets, middle, end, cap);

invokeAll(leftTask, rightTask);
}
}