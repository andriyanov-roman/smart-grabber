package smartgrabber.collection_analyzer;

/**
 * Created by randriyanov on 25.10.15.
 */
public interface ITimeAnalyzer<T> {

    Long findTime(T t);
}
