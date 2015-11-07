package smartgrabber.collection_analyzer.queues;

import com.carrotsearch.sizeof.RamUsageEstimator;


import java.util.Queue;

/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public class QueueAnalyzerImpl implements IQueueAnalyzer {

    private Queue queue;

    public QueueAnalyzerImpl(Queue queue) {
        this.queue = queue;
    }

    @Override
    public Long findMemory(Queue queue) {
        return RamUsageEstimator.sizeOf(queue);
    }


    @Override
    public Long findTime(ITimer iTimer) {

        return null;
    }

    @Override
    public String addElement(Object obj) {
        ITimer iTimer = new TimerImpl();
        queue.add(obj);
        return "Time of adding"+iTimer.retrieveSpendingTime();
    }

    @Override
    public String removeElement(Object o) {
        return null;
    }
}




