package smartgrabber.collection_analyzer.sets;
import com.carrotsearch.sizeof.RamUsageEstimator;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2015.
 */
public class SetAnalyzerImpl implements ISetAnalyzer<Set>{
    private long startTime;
    private long estimatedTime;
    @Override
    public Long findMemory(Set set) {
        return RamUsageEstimator.sizeOf(set);
    }

    @Override
    public Long insertionTime(Set set) {
        startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {

            set.add("TEST_STRING"+System.nanoTime());
        }
        estimatedTime = System.nanoTime() - startTime;

        //System.out.println("set size: "set.size());
        return estimatedTime;
    }
}
