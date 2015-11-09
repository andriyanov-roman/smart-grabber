package smartgrabber.concurrency.h_future;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SimpleCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }

        };
        return 0;
    }
}