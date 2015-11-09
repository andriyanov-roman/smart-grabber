package smartgrabber.concurrency.e_synchronization.entity;

/*
 * A <i>thread</i> is a thread of execution in a program. The Java
 * Virtual Machine allows an application to have multiple threads of
 * execution running concurrently.
*/

public class SimpleThread implements Runnable{ // public class Thread implements Runnable {}
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
