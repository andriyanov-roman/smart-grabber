package smartgrabber.concurrency.my_synchronized_collection;

import org.junit.BeforeClass;
import org.junit.Test;
import smartgrabber.sync_arraylist.SyncArrayList;

/**
 * Created by R-Tem on 13.11.2015.
 */
public class TestSyncArrayList {

    private static SyncArrayList syncArrayList;
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
        syncArrayList = new SyncArrayList();

        addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-adding");
                threadMessage("started ");
                int counter = 0;
                while (true) {
                    try {
                        syncArrayList.add(Thread.currentThread().getName() + " Test" + counter++);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-removing");
                threadMessage("started");
                while (true) {
                    try {
                        if (syncArrayList.size() < 10) {
                            Thread.sleep(1000);
                            syncArrayList.remove(0);
                        } else syncArrayList.remove(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Test
    public void testInfiniteAdding() throws InterruptedException {
        addThread.start();
    }

    public static void main(String[] args) {
        syncArrayList = new SyncArrayList((short)3);

        addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-adding");
                threadMessage("started");
                for (int i = 0; i < 15; i++) {
                    syncArrayList.add("Test Element " + i);
                }
            }
        });

        addThread.start();
    }
}
