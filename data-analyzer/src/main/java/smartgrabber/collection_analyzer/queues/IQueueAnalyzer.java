package smartgrabber.collection_analyzer.queues;


import smartgrabber.collection_analyzer.IMemoryAnalyzer;

import java.util.Collection;
import java.util.Queue;


/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public interface IQueueAnalyzer <T extends Queue> extends IMemoryAnalyzer <T>{
    @Override
    Long findMemory(T t);

    @Override
    Long findTime(ITimer iTimer);

    String addElement (Object o);
    String removeElement (Object o);
}
