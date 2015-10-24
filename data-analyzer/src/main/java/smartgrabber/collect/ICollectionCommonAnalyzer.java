package smartgrabber.collect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public interface ICollectionCommonAnalyzer<T extends Collection> {

    <U extends Number> U findMemory(T t);
}
