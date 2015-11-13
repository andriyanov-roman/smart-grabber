package smartgrabber.concurrency.e_synchronization.entity;

/**
 * Created by R-Tem on 12.11.2015.
 */
public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
