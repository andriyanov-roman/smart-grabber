package smartgrabber.concurrency.e_synchronization.synchro_method;

import smartgrabber.concurrency.e_synchronization.synchro_method.SimpleThread;
import smartgrabber.concurrency.e_synchronization.synchro_method.SynchroMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by randriyanov on 01.11.15.
 */
public class MainSynchroTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        SynchroMethod method = new SynchroMethod();
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new SimpleThread(method);
            executor.execute(runnable);
        }
        executor.shutdown();
        method.getArrayList().forEach(System.out::println);
    }
}
