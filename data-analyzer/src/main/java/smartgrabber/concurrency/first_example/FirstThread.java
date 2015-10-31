package smartgrabber.concurrency.first_example;


public class FirstThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                Thread.currentThread().sleep(1000);
                System.out.println("Hello from first thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
