public class ParallelMaxSearch extends SensorSearchEngine {

    public ParallelMaxSearch(double[] sensorData, int startIdx, int endIdx) {
        this.sensorData = sensorData;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    public double processGrid() {
        double maximum = -Double.MAX_VALUE;

        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] > maximum) {
                maximum = sensorData[i];
            }
        }

        return maximum;
    }
}