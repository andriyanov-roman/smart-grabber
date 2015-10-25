package smartgrabber.collect2;

import java.util.Map;

/**
 * Created by randriyanov on 25.10.15.
 */
public interface IMapAnalyzer<T extends Map> extends IMemoryAnalyzer<T> {

    Long findTime(T t);
    Long findMemory(T t);
}
