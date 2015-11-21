package smartgrabber.concurrency.my_synchronized_collection;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by R-Tem on 13.11.2015.
 */
public class TestSyncArrayList {

    public static final String WITH_LISTENER = "With Listener";

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
        syncArrayList = new SyncArrayList(WITH_LISTENER);

        addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-adding");
                threadMessage("started");
                int counter = 0;
                for (int i = 0; i < 20; i++) {
                    syncArrayList.add("Test Element " + counter++);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        addThread.start();
    }
}
