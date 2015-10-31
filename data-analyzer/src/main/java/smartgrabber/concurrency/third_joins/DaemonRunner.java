package smartgrabber.concurrency.third_joins;

/**
 * Created by randriyanov on 24.08.15.
 */
public class DaemonRunner {
    public static void main(String[ ] args) {

        SimpleThread usual = new SimpleThread();

        Thread daemon = new DaemonThread();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();

    }
}
