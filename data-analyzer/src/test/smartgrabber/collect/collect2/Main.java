package smartgrabber.collect.collect2;

import java.util.ArrayList;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        arrayList.add("1sdfsdfsdfsdfsdfsdfsd");
        ArrayListTaskImpl task = new ArrayListTaskImpl();
        Long memSize = task.findMemory(arrayList);
        System.out.println(memSize+" BYTES");
        System.out.println("Time for deleting: "+(task.showTimeDeleting(arrayList))+" nanoSECONDS");
        arrayList.forEach(System.out::println);
    }
}
