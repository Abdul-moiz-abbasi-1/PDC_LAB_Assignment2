public class TradingEngineApp {
    public static void main(String[] args) {
    
    TradeEvent event1 = new TradeEvent(
    "GEN-001", System.currentTimeMillis(), 1000.0
);

event1.dispatch();

TradeEvent event2 = new FIXOrderEvent(
    "FIX-001", System.currentTimeMillis(), 1000.0, "ORD-101"
);

event2.dispatch();

    }
}