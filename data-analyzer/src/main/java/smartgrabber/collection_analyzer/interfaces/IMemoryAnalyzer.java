package smartgrabber.collection_analyzer.interfaces;


public interface IMemoryAnalyzer<T> extends ITimeAnalyzer<T> {

    Long findMemory(T t);
}
