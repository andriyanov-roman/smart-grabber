package smartgrabber.collection_analyzer.total;

import smartgrabber.collection_analyzer.interfaces.IMemoryAnalyzer;

import java.util.Collection;

/**
 * Created by R-Tem on 04.11.2015.
 */
public interface ICollectionAnalyzer<T extends Collection> extends IMemoryAnalyzer<T> {

    @Override
    Long insertionTime(T t);

    long removeTime(Object o);
    long removeAllTime(Object o);
    long removeFromStartTime(Object o);
    long removeFromInsideTime(Object o);
    long clearingTime(Object o);

    @Override
    Long findMemory(T t);

}
