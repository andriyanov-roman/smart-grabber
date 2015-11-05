package smartgrabber.collection_analyzer.map;

import smartgrabber.collection_analyzer.interfaces.IMemoryAnalyzer;

import java.util.Map;

/**
 * Created by randriyanov on 25.10.15.
 */
public interface IMapAnalyzer<T extends Map> extends IMemoryAnalyzer<T> {

    Long insertionTime(T t);
    Long findMemory(T t);
}
