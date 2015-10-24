package smartgrabber.collect;

import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface ICollectionMemoryAnalyzer<T extends Collection> extends ICollectionCommonAnalyzer{
    <U extends Number> U findMemory(T t);
}
