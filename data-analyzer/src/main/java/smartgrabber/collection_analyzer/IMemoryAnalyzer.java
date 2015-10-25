package smartgrabber.collection_analyzer;


public interface IMemoryAnalyzer<T> extends ITimeAnalyzer<T> {

    Long findMemory(T t);
}
