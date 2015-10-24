package smartgrabber.collect;

import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface ICollectionTimeAnalyzer<T extends Collection> {
    <U extends Number> U startTimeCount (T t);
    <U extends Number> U stopTimeCount (T t);
    <U extends Number> U showTime (T t);
}
