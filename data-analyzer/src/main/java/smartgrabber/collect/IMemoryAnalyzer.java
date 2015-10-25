package smartgrabber.collect;


public interface IMemoryAnalyzer<T> extends ITimeAnalyzer<T> {

    Long findMemory(T t);
}
