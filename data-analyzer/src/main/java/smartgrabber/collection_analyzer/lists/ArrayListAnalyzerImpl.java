package smartgrabber.collection_analyzer.lists;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public class ArrayListAnalyzerImpl implements IListAnalyzer {

    @Override
    public Long retrieveUsedMemory(Object o) {
        return null;
    }

    @Override
    public Long retrieveExecutionTime(IExecutor iExecutor) {
        Long startExecutionTime = System.nanoTime();
        iExecutor.execute();
        Long endExecutionTime = System.nanoTime();
        return endExecutionTime-startExecutionTime;
    }
}
