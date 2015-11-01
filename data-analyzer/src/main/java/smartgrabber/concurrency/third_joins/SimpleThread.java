package smartgrabber.concurrency.third_joins;

/**
 * Created by randriyanov on 24.08.15.
 */
public class SimpleThread extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.currentThread().sleep(1000);
                System.out.println("старт обычного потока");
            }
        } catch (InterruptedException e) {
            System.err.print(e);
        }
    }
}
