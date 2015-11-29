package smartgrabber.collection_analyzer.lists;

import smartgrabber.collection_analyzer.lists.ICollectionAnalyzer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by R-Tem on 04.11.2015.
 */
public class ArrayListAnalyzer implements ICollectionAnalyzer<ArrayList> {

    private long startTime;
    private long estimatedTime;

    @Override
    public Long insertionTime(ArrayList arrayList) {
        estimatedTime = 0;


        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add("TEST_STRING");
        }
        estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    public Long insertionTime(ArrayList arrayList, Object o) {
        if (o.getClass() == ArrayList.class
                || o.getClass() == LinkedList.class
                || o.getClass() == List.class){
            startTime = System.nanoTime();
            arrayList.addAll((Collection) o);
            estimatedTime = System.nanoTime() - startTime;
        } else {
            startTime = System.nanoTime();
            arrayList.add(o);
            estimatedTime = System.nanoTime() - startTime;
        }
        return estimatedTime;
    }

    public Long insertionTime(ArrayList arrayList, Object o, int index) {
        if (o.getClass() == ArrayList.class
                || o.getClass() == LinkedList.class
                || o.getClass() == List.class){
            startTime = System.nanoTime();
            arrayList.addAll(index, (Collection) o);
            estimatedTime = System.nanoTime() - startTime;
        } else {
            startTime = System.nanoTime();
            arrayList.add(index, o);
            estimatedTime = System.nanoTime() - startTime;
        }
        return estimatedTime;
    }

    @Override
    public long removeTime(Object o) {
        return 0;
    }

    @Override
    public long removeAllTime(Object o) {
        return 0;
    }

    @Override
    public long removeFromStartTime(Object o) {
        return 0;
    }

    @Override
    public long removeFromInsideTime(Object o) {
        return 0;
    }

    @Override
    public long clearingTime(Object o) {
        return 0;
    }

    @Override
    public Long findMemory(ArrayList arrayList) {
        return null;
    }
}
