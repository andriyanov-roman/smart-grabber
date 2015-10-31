package smartgrabber.concurrency;

import smartgrabber.concurrency.first_example.FirstThread;
import smartgrabber.concurrency.first_example.SecondThread;

/**
 * Created by randriyanov on 31.10.15.
 */
public class Main {
    public static void main(String[] args) {
        Thread first = new FirstThread();
        Thread second = new Thread(new SecondThread());

        first.start();
        second.start();
    }
}
