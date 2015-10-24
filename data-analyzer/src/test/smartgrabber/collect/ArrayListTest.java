package smartgrabber.collect;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public class ArrayListTest implements ICollectionTimeAnalyzer, ICollectionMemoryAnalyzer {
    private Long startTime, stopTime;
    public void run() {
        ArrayList<String> array = new ArrayList<String>();
        array.add("bla");
        array.add("blo");
        array.add("blu");
        array.add("blia");
        array.add("ble");
        array.add("brrrr");
        array.add("buuu");
         startTime = System.nanoTime();

    }

    public Number startTimeCount() {

        return null;
    }

    public Long stopTimeCount() {
         stopTime = System.nanoTime();
        showTime(stopTime - startTime);
        return null;
    }
    public void showTime(long time) {
        System.out.println(String.format(Locale.ENGLISH, "Time:%s ns", NumberFormat.getNumberInstance().format(time)));
    }

    public Long findMemory() {
        return null;
    }

    public Number findMemory(Collection collection) {
        return null;
    }

    public Number showTime() {
        return null;
    }
}
