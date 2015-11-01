package smartgrabber.concurrency.third_joins;

/**
 * Created by randriyanov on 31.10.15.
 */
public class DaemonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.currentThread().sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon");
        }
    }
}
