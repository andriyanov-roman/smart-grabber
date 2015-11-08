package smartgrabber.collection_analyzer.queues;

import com.carrotsearch.sizeof.RamUsageEstimator;


import java.util.Queue;

/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public class QueueAnalyzerImpl implements IQueueAnalyzer {

    private Queue queue;
    private Long startTime;
    private Long endTime;

    /*public QueueAnalyzerImpl(Queue queue) {
        this.queue = queue;
    }*/

    @Override
    public Long findMemory(Queue queue) {
        return RamUsageEstimator.sizeOf(queue);
    }



    @Override
    public Long findTime(Executable executable) {
        startTime = System.nanoTime();
        executable.execute();
        endTime = System.nanoTime();
        return endTime - startTime;
    }


}




