package smartgrabber.collection_analyzer.queues;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public interface ITimer<T extends Executable> {
    Long retrieveSpendingTime(T t);
}
