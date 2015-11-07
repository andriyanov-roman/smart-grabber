package smartgrabber.collection_analyzer.sets;
import com.carrotsearch.sizeof.RamUsageEstimator;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2015.
 */
public abstract class SetAnalyzer implements ISetAnalyzer<Set>{

    @Override
    public Long findMemory(Set set) {
        return RamUsageEstimator.sizeOf(set);
    }

}
