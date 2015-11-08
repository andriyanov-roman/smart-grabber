package smartgrabber.collection_analyzer.lists;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public interface IExecutor<T> {
    void execute();
    void addElement(T t);
}
