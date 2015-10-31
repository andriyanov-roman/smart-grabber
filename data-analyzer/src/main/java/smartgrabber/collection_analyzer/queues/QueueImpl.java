package smartgrabber.collection_analyzer.queues;

import com.carrotsearch.sizeof.RamUsageEstimator;


import java.util.Queue;

/**
 * by Aliso4ka1313 on 31.10.2015.
 */
public class QueueImpl implements IQueueAnalyzer <Queue>{


    @Override
    public Long findMemory(Queue queue) {
        return RamUsageEstimator.sizeOf(queue);
    }

    @Override
    public Long findTime(Queue queue) {
        Long start = System.nanoTime();

        Long end = System.nanoTime();
        return end-start;
    }

   /* @Override
    public Long removeTime(Collection collection) {
        Long start = System.nanoTime();
        ((Queue)collection).remove(6);
        Long end = System.nanoTime();
        return end-start;
    }

    @Override
    public Long addFirstTime(Collection collection) {
        Long start = System.nanoTime();
       // ((Queue)collection).add();
        Long end = System.nanoTime();
        return end-start;
    }



    @Override
    public Long addLastTime (Collection collection) {
        return null;
    }*/
}
