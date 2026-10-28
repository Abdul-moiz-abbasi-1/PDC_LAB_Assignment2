import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SensorGridMonitorApp {

    public static void main(String[] args) {
    
int size = 50000;
double[] sensorData = new double[size];

for (int i = 0; i < size; i++) {
    sensorData[i] = 20 + Math.random() * 80;
}

System.out.println("Total sensor readings: " + size);

int segmentSize = size / 4;

System.out.println("Number of worker threads: 4");
System.out.println("Sensor readings per segment: " + segmentSize);
 ExecutorService executor = Executors.newFixedThreadPool(4);

List<Future<Double>> minResults = new ArrayList<>();
List<Future<Double>> maxResults = new ArrayList<>();

long startTime = System.nanoTime(); 
for (int worker = 0; worker < 4; worker++) {
    int start = worker * segmentSize;
    int end = (worker == 3) ? size : start + segmentSize;

    minResults.add(executor.submit(
        () -> new ParallelMinSearch(sensorData, start, end).processGrid()
    ));

    maxResults.add(executor.submit(
        () -> new ParallelMaxSearch(sensorData, start, end).processGrid()
    ));
}  
}
}
