package smartgrabber.collection_analyzer.queues;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public class TimerImpl implements ITimer{
    private Long startTime;
    private Long endTime;

    public TimerImpl( ) {
        this.startTime = System.nanoTime();
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long retrieveSpendingTime(){
        endTime = System.nanoTime();
        return endTime - startTime;
    }
}
