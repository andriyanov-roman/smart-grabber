package smartgrabber.collect;

import com.carrotsearch.sizeof.RamUsageEstimator;
import smartgrabber.collection_analyzer.find_interfaces.IFindCollectionMemory;
import smartgrabber.collection_analyzer.find_interfaces.IFindCollectionTime;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public class ArrayListTaskImpl implements IFindCollectionMemory,IFindCollectionTime {


    public Long findMemory(Collection collection) {
       return RamUsageEstimator.sizeOf(collection);

    }

    public Long showTimeDeleting(Collection collection) {
        Long start = System.nanoTime();
        ((ArrayList)collection).remove(6);
        Long end = System.nanoTime();
        return end-start;
    }

    public Long showTimeBeginInserting(Collection collection) {
        Long start = System.nanoTime();
        ((ArrayList)collection).add(0, "");
        Long end = System.nanoTime();
        return end-start;
    }

    public Long showTimeMiddleInserting(Collection collection) {
        ArrayList arrayList = (ArrayList) collection;
        int middle = (int) Math.ceil(arrayList.size()/2);
        System.out.println(middle);
        Long start = System.nanoTime();
        arrayList.add(middle, "RRRRRRRRRRRRRRRRRRRRRRRR");
        Long end = System.nanoTime();
        return end-start;
    }

    public Long showTimeEndInserting(Collection collection) {
        ArrayList arrayList = (ArrayList) collection;
        Long start = System.nanoTime();
        arrayList.add("GGGGGGGGG");
        Long end = System.nanoTime();
        return end-start;
    }
    public Long showTimeMillionInserting(Collection collection) {
        ArrayList arrayList = (ArrayList) collection;
        Long start = System.nanoTime();
        for (int i = 0; i < 999999; i++) {
            arrayList.add("GGGGGGGGG");
        }
        Long end = System.nanoTime();
        return end-start;
    }
}
