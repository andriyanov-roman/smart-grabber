package smartgrabber.concurrency.c_priority;

/**
 * Created by randriyanov on 24.08.15.
 */
public class PriorThread extends Thread {
    public PriorThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(1000); // попробовать sleep(0),sleep(10)
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }
}
