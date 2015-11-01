package smartgrabber.concurrency.fouth_synchronization;

import java.io.IOException;

/**
 * Created by randriyanov on 24.08.15.
 */
public class SynchroRun {
    public static void main(String[] args) {

        Resource s = null;
        try {
            s = new Resource("result.txt");
            SyncThread t1 = new SyncThread("First", s);
            SyncThread t2 = new SyncThread("Second", s);
            t1.start();
            t2.start();

        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (Exception e) {
            System.err.print("ошибка потока: " + e);
        } finally {
            s.close();
        }
    }
}
