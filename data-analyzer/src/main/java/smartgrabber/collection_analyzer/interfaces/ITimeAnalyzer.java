package smartgrabber.collection_analyzer.interfaces;

/**
 * Created by randriyanov on 25.10.15.
 */
public interface ITimeAnalyzer<T> {

    Long insertionTime(T t);
}
