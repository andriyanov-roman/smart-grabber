package smartgrabber.concurrency;

import smartgrabber.concurrency.a_defining.SubclassThread;
import smartgrabber.concurrency.a_defining.RunnableThread;

/**
 * Created by randriyanov on 31.10.15.
 */
public class Main {
    public static void main(String[] args) {
        Thread first = new SubclassThread();
        Thread second = new Thread(new RunnableThread());

        first.start();
        second.start();
    }
}
