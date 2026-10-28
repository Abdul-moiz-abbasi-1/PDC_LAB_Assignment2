public class ParallelMinSearch extends SensorSearchEngine {

    public ParallelMinSearch(double[] sensorData, int startIdx, int endIdx) {
        this.sensorData = sensorData;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    public double processGrid() {
        double minimum = Double.MAX_VALUE;

        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] < minimum) {
                minimum = sensorData[i];
            }
        }

        return minimum;
    }
}