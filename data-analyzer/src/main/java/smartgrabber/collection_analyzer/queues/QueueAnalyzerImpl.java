package smartgrabber.collection_analyzer.queues;

import com.carrotsearch.sizeof.RamUsageEstimator;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public class QueueAnalyzerImpl implements IQueueAnalyzer <Queue> {

    @Override
    public Long findMemory(Queue queue) {
        return RamUsageEstimator.sizeOf(queue);
    }

    @Override
    public Long findTime(Executable executable) {
         Long startTime = System.nanoTime();
        executable.execute();
        return System.nanoTime() - startTime;
    }
}




