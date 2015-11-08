package smartgrabber.collection_analyzer;




public interface IMemoryAnalyzer<T> extends ITimeAnalyzer {

    Long findMemory(T t);
}
