package smartgrabber.collection_analyzer.find_interfaces;

import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface IFindCollectionMemory<T extends Collection> {
    Long findMemory(T t);
}
