public class TradingEngineApp {
    public static void main(String[] args) {
    
    TradeEvent event1 = new TradeEvent(
    "GEN-001", System.currentTimeMillis(), 1000.0
);

event1.dispatch();
    }
}