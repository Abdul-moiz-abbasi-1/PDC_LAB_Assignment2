public class TelemetryThread extends Thread {
@Override
public void run() {
    for (int i = 1; i <= 5; i++) {
        System.out.println(
            getName() + " collecting telemetry " + i
        );
    }
}
}