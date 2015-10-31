package smartgrabber.concurrency.first_example;


public class SecondThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                Thread.currentThread().sleep(1000);
                System.out.println("Hello from second thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
