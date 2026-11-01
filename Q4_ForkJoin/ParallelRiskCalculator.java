import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double> {

    private double[] risks;
    private int start;
    private int end;
    private static final int THRESHOLD = 1000;

    public ParallelRiskCalculator(double[] risks, int start, int end) {
        this.risks = risks;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        if (end - start <= THRESHOLD) {
            double total = 0;

            for (int i = start; i < end; i++) {
                total += risks[i];
            }

            return total;
        }

        int middle = (start + end) / 2;

        ParallelRiskCalculator leftTask =
                new ParallelRiskCalculator(risks, start, middle);

        ParallelRiskCalculator rightTask =
                new ParallelRiskCalculator(risks, middle, end);

        leftTask.fork();

        double rightResult = rightTask.compute();
        double leftResult = leftTask.join();

        return leftResult + rightResult;
    }
}