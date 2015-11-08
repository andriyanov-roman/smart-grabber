package smartgrabber.collection_analyzer.lists;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mit_OK! on 07.11.2015.
 */
abstract class ListAnalyzerImpl<T> implements IListAnalyzer {
    protected List<T> list;

    @Override
    public Long retrieveExecutionTime(IExecutor iExecutor) {
        Long startExecutionTime = System.nanoTime();
        iExecutor.execute();
        Long endExecutionTime = System.nanoTime();
        return endExecutionTime-startExecutionTime;
    }

    @Override
    public Long retrieveUsedMemory() {
        return RamUsageEstimator.sizeOf(list);
    }
}
