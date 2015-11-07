package smartgrabber.collection_analyzer;


import smartgrabber.collection_analyzer.queues.ITimer;

public interface IMemoryAnalyzer<T> extends ITimeAnalyzer {

    Long findMemory(T t);
}
