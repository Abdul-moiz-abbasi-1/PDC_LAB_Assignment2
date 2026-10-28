public class AsyncWebEngineApp {
public static void main(String[] args) {
    System.out.println("Main thread: "
            + Thread.currentThread().getName());
    TelemetryThread telemetry = new TelemetryThread();
telemetry.setName("Telemetry-Worker");
telemetry.start();
}
}