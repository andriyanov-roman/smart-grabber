package smartgrabber.concurrency.fouth_synchronization;


public class SimpleThread implements Runnable{
    private SynchroMethod synchroMethod;

    public SimpleThread(SynchroMethod synchroMethod) {
        this.synchroMethod = synchroMethod;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchroMethod.addNewElement();
        }
    }
}
