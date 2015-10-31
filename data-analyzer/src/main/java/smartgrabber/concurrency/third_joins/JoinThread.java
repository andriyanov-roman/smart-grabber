package smartgrabber.concurrency.third_joins;

/**
 * Created by randriyanov on 24.08.15.
 */
public class JoinThread extends Thread {
    private Thread thread;

    public JoinThread(String name) {
        super(name);
    }

    public JoinThread(String name,Thread thread) {
        super(name);
        this.thread = thread;
    }

    public void run() {

        String nameT = getName();
        long timeout = 0;
        System.out.println("Старт потока " + nameT);
        try {
            for (int i = 0; i < 10; i++) {
                if(thread != null) {
                    thread.join();
                }
                switch (nameT) {
                    case "First":
                        timeout = 5_000;
                    case "Second":
                        timeout = 1_000;
                }
                Thread.sleep(timeout);
                System.out.println("завершение потока " + nameT);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
