package smartgrabber.collection_analyzer;

import org.junit.Before;
import org.junit.Test;
import smartgrabber.collection_analyzer.sets.ISetAnalyzer;
import smartgrabber.collection_analyzer.sets.SetAnalyzerImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2015.
 */
public class TestSetAnalyzer {
    Long insertionTime;
    Set set = new HashSet<String>();
    ISetAnalyzer  setAnalyzer = new SetAnalyzerImpl();
    @Before
    public void initialize(){

        insertionTime = setAnalyzer.insertionTime(set);
    }

    @Test
    public  void testSetSize(){
        System.out.println("Set Memory usage: "+ setAnalyzer.findMemory(set));
    }

    @Test
    public void testSetTime(){

        System.out.println(insertionTime);
    }
}
