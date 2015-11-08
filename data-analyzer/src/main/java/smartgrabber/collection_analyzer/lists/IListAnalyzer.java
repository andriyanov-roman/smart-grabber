package smartgrabber.collection_analyzer.lists;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.List;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public interface IListAnalyzer <T extends List> extends IMemoryConsumption {
    @Override
    Long retrieveUsedMemory();

}
