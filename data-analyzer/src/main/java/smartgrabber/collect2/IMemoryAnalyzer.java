package smartgrabber.collect2;


public interface IMemoryAnalyzer<T> extends ITimeAnalyzer<T> {

    Long findMemory(T t);
}
