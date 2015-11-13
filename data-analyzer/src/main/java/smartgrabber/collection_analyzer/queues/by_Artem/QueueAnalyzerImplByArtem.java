package smartgrabber.collection_analyzer.queues.by_Artem;

import com.carrotsearch.sizeof.RamUsageEstimator;
import smartgrabber.collection_analyzer.queues.Executable;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by R-Tem on 13.11.2015.
 *
 * Здесь попробуй поиграть с жденериками!
 */
public class QueueAnalyzerImplByArtem implements IQueueAnalyzerByArtem <Queue> {

    @Override
    public Long findMemory(Queue queue) {
        return RamUsageEstimator.sizeOf(queue);
    }

    @Override
    public Long findTime(Executable executable) {
        long startTime = System.nanoTime();
        executable.execute();
        return System.nanoTime() - startTime;
    }

/*
    // такой результат будет если вместо <Queue> подставить <ArrayList>

    @Override
    public Long findMemory(ArrayList arrayList) {
        return null;
    }
*/

/*
    // такой результат будет если вместо <Queue> подставить <Т>

    @Override
    public Long findMemory(T t) {
        return null;
    }
*/
}
