package smartgrabber.collection_analyzer.sets;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2015.
 */
public class SetDeleteAnalyzer extends SetAnalyzer {

    private long startTime;
    private long estimatedTime;
    private ArrayList<String> arrayList;

    @Override
    public Long insertionTime(Set set) {
        arrayList = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add("TEST_STRING"+System.nanoTime());
            set.add("TEST_STRING"+System.nanoTime());
        }

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            set.remove(arrayList.get(i));
        }
        estimatedTime = System.nanoTime() - startTime;

        //System.out.println("set size: "set.size());
        return estimatedTime;
    }
}
