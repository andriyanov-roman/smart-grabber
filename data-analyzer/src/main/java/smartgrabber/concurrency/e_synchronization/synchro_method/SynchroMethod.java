package smartgrabber.concurrency.e_synchronization.synchro_method;


import smartgrabber.concurrency.my_synchronized_collection.SyncArrayList;

import java.util.ArrayList;

public class SynchroMethod {

    private SyncArrayList<String> arrayList = new SyncArrayList<>();

    public SyncArrayList<String> getArrayList() {
        return arrayList;
    }

    public void addNewElement() {
        synchronized (arrayList) {
            if (arrayList.size() > 10) {
                try {
                    arrayList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                arrayList.add(Thread.currentThread().getName() + " From addNewElement");
            }
        }
    }

}
