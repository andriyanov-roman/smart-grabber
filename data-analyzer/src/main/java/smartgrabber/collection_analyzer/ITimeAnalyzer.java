package smartgrabber.collection_analyzer;


import smartgrabber.collection_analyzer.queues.ITimer;

import java.util.Collection;

/**
 * Created by randriyanov on 25.10.15.
 */
public interface ITimeAnalyzer<T extends ITimer> {

    Long findTime(T t);
}
