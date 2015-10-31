package smartgrabber.collection_analyzer.queues;


import smartgrabber.collection_analyzer.IMemoryAnalyzer;

import java.util.Collection;


/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public interface IQueueAnalyzer <T extends Collection> extends IMemoryAnalyzer <T>{
    @Override
    Long findMemory(T t);


    @Override
    Long findTime(T t);
}
