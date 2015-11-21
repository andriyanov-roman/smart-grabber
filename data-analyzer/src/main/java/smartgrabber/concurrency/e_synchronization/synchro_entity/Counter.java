package smartgrabber.concurrency.e_synchronization.synchro_entity;

/**
 * Created by randriyanov on 24.08.15.
 */
public class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}
