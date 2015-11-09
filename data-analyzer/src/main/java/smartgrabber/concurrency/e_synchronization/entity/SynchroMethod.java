package smartgrabber.concurrency.e_synchronization.entity;


import java.util.ArrayList;

public class SynchroMethod {

    private ArrayList<String> arrayList = new ArrayList<>();

    public ArrayList<String> getArrayList() {
        return arrayList;
    }
    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
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
