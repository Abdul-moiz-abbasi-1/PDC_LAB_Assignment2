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
    }
}
