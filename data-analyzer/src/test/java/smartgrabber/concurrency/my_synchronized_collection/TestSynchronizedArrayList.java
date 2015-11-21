package smartgrabber.concurrency.my_synchronized_collection;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by R-Tem on 13.11.2015.
 */
public class TestSynchronizedArrayList {

    private static SynchronizedArrayList syncArrayList;
    private static Thread addThread;
    private static Thread removeThread;

    // Display a message, preceded by
    // the name of the current addThread
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    @BeforeClass
    public static void ini() {
        syncArrayList = new SynchronizedArrayList();

        addThread = new Thread(new Runnable() {

            @Override
            public void run() {
                Thread.currentThread().setName("Thread-add");
                threadMessage("started");
                syncArrayList.add("'test from addThread'");
                threadMessage("ended");
            }
        });

        removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-remove");
                threadMessage("started");
                try {
                    Thread.sleep(500);
                    syncArrayList.remove("'test1'");
                    threadMessage("ended");
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done!");
                }
            }
        });
    }

    @Test
    public void test() throws InterruptedException {
        syncArrayList.add("'test1'");
        System.out.println("size: " + syncArrayList.size() + " item0: " + syncArrayList.get(0) + "\n");
        addThread.start();
        Thread.sleep(500);
        System.out.println("main slept 0.5s");
        removeThread.start();
        System.out.println("\nsize: " + syncArrayList.size() + " item0: " + syncArrayList.get(0));
    }

    @Test
    public void testWithInterrupting() throws InterruptedException {
        syncArrayList.add("'test1'");
        System.out.println("size: " + syncArrayList.size() + " item0: " + syncArrayList.get(0) + "\n");
        addThread.start();
        Thread.sleep(500);
        System.out.println("main slept 0.5s");
        removeThread.start();
        Thread.sleep(100);
        System.out.println("main slept 0.1s");
        removeThread.interrupt();
        removeThread.join();
        System.out.println("\nsize: " + syncArrayList.size() + " item0: " + syncArrayList.get(0));
    }
}
