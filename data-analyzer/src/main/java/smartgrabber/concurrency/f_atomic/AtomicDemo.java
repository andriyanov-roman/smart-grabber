package smartgrabber.concurrency.f_atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by randriyanov on 24.08.15.
 */
public class AtomicDemo {
    private static final int NUMBER_BROKERS = 30;

    public static void main(String[] args) {

        Market market = new Market(new AtomicLong(100));
        market.start();
        for (int i = 0; i < NUMBER_BROKERS; i++) {
            new Broker(market).start();
        }
    }
}
