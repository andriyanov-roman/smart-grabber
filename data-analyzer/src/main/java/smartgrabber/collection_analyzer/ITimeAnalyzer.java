package smartgrabber.collection_analyzer;


import smartgrabber.collection_analyzer.queues.Executable;

/**
 * Created by randriyanov on 25.10.15.
 */
public interface ITimeAnalyzer<T extends Executable> {

    Long findTime(T t);
}
