package smartgrabber.collection_analyzer.find_interfaces;

import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface IFindCollectionTime<T extends Collection> extends IFindCollectionMemory {
   Long showTimeDeleting(T t);
   Long showTimeBeginInserting(T t);
   Long showTimeMiddleInserting(T t);
   Long showTimeEndInserting(T t);
}
