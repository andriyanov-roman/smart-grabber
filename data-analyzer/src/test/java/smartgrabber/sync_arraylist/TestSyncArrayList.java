package smartgrabber.sync_arraylist;

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

    public static void main(String[] args) {
        syncArrayList = new SyncArrayList((short)3);

        addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-adding");
                threadMessage("started");
                // cycle for can be replaced by while(true)
                for (int i = 0; i < 15; i++) {
                    syncArrayList.add("Test Element " + i);
                }
            }
        });

        addThread.start();
    }
}
