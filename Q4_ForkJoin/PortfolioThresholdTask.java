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
}