package smartgrabber.concurrency.d_joins;

/**
 * The following example brings together some of the concepts of this section.
 * SimpleThreads consists of two threads.
 * The first is the main thread that every Java application has.
 * The main thread creates a new thread from
 * the Runnable object, MessageLoop, and waits for it to finish.
 * If the MessageLoop thread takes too long to finish, the main thread interrupts it.
 *
 * The MessageLoop thread prints out a series of messages.
 * If interrupted before it has printed all its messages,
 * the MessageLoop thread prints a message and exits.
 */
public class SimpleThreads {
    // Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String message) {
        String threadName =
                Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }

    private static class MessageLoop
            implements Runnable {
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            try {
                for (String anImportantInfo : importantInfo) {
                    // Pause for 3 seconds
                    /*
                    * Ìåòîä .sleep() ÎÑÒÀÍÀÂËÈÂÀÅÒ ïîòîê ÄËß êîòîðîãî áûë âûçâàí
                    */
                    Thread.sleep(3000);
                    // Print a message
                    threadMessage(anImportantInfo);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default 10 sec).
        long patience = 10000;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");

        // loop until MessageLoop thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting... "
                    + (System.currentTimeMillis()-startTime) + " ms");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.

            /*
            * Ìåòîä .join() ÎÑÒÀÍÀÂËÈÂÀÅÒ ïîòîê ÈÇ êîòîðîãî áûë âûçâàí
            * íà óêàçàííîå, â ms, âðåìÿ
            * è ÏÅÐÅÊËÞ×ÀÅÒ ïðîöåññ íà ïîòîê ÄËß êîòîðîãî áûë âûçâàí
            */
            t.join(500);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting! "
                        + (System.currentTimeMillis() - startTime) + " ms");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
