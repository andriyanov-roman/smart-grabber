package smartgrabber.collect.collect2;

import com.carrotsearch.sizeof.RamUsageEstimator;
import smartgrabber.collect2.IFindCollectionMemory;
import smartgrabber.collect2.IFindCollectionTime;

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
        ((ArrayList)collection).remove(0);

        return null;
    }

    public Long showTimeBeginInserting(Collection collection) {
        return null;
    }

    public Long showTimeMiddleInserting(Collection collection) {
        return null;
    }

    public Long showTimeEndInserting(Collection collection) {
        return null;
    }
}
