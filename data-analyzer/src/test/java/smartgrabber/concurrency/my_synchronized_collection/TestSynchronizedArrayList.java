package smartgrabber.concurrency.my_synchronized_collection;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by R-Tem on 13.11.2015.
 */
public class TestSynchronizedArrayList {

    private static SynchronizedArrayList syncArrayList;
    private static Thread t1;
    private static Thread t2;

    @BeforeClass
    public static void ini(){
        syncArrayList = new SynchronizedArrayList();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncArrayList.add("test from t1");
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncArrayList.remove("test1");
            }
        });
    }

    @Test
    public void test(){
        syncArrayList.add("test1");
        System.out.println(syncArrayList.size() + " " + syncArrayList.get(0));
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        System.out.println(syncArrayList.size() + " " + syncArrayList.get(0));
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(syncArrayList.size() + " " + syncArrayList.get(0));
    }
}
