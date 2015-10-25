package smartgrabber.collect;

import java.util.Map;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface IFindMapMemory<T extends Map> {
    Long findMemory(T t);
}
