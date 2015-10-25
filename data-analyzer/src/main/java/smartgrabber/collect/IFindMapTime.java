package smartgrabber.collect;

import java.util.Map;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface IFindMapTime<T extends Map> {
   Long showTimeDeleting(T t);
   Long showTimeBeginInserting(T t);
   Long showTimeMiddleInserting(T t);
   Long showTimeEndInserting(T t);
}
