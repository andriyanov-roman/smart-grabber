package smartgrabber.collect;

import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public class ArrayListTest implements ICollectionTimeAnalyzer {
    public Long showTime(Collection collection) {
        return System.nanoTime();
    }


}
