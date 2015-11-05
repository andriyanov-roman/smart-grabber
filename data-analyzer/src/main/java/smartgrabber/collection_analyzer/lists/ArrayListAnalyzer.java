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

    // Вставляет 1 000 000 объектов через fori
    @Override
    public Long insertionTime(ArrayList arrayList) {
        estimatedTime = 0;

        // Закоментированный вариант авлгоритма дает ~ В 2 РАЗА большие значения.
        // Хотя на мой взгляд должно было быть наоборот...

//        for (int i = 0; i < 1000000; i++) {
//            startTime = System.nanoTime();
//            arrayList.add("TEST_STRING");
//            estimatedTime = estimatedTime + (System.nanoTime() - startTime);
//        }

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add("TEST_STRING");
        }
        estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    // Вставляет 1 объект в конец с помощью add()
    // Или множество объектов из другой коллекции с помощью addAll()
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

    // Вставляет 1 объект в место с указанным индексом с помощью add()
    // Или множество объектов из другой коллекции в место с указанным индексом с помощью addAll()
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
