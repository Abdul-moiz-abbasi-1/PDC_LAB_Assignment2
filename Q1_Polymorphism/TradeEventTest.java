
public class TradeEventTest {
    public static void main(String[] args) {
        TradeEvent event = new TradeEvent(
            "TEST-001",
            System.currentTimeMillis(),
            100.0
        );

        event.dispatch();
    }
}
