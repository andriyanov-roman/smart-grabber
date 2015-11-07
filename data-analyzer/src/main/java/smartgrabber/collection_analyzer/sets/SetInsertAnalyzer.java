package smartgrabber.collection_analyzer.sets;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2015.
 */
public class SetInsertAnalyzer extends  SetAnalyzer
{
    private long startTime;
    private long estimatedTime;

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
