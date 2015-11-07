package smartgrabber.collection_analyzer;

import org.junit.Before;
import org.junit.Test;
import smartgrabber.collection_analyzer.sets.ISetAnalyzer;
import smartgrabber.collection_analyzer.sets.SetAnalyzer;
import smartgrabber.collection_analyzer.sets.SetDeleteAnalyzer;
import smartgrabber.collection_analyzer.sets.SetInsertAnalyzer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 07.11.2015.
 */
public class TestSetAnalyzer {
    Long insertionTime;
    Long deletionTime;
    Set set = new HashSet<String>();


    @Before
    public void initialize(){


    }

    @Test
    public  void testSetSize(){
        //System.out.println("Set Memory usage: "+ SetInsertAnalyzer.findMemory(set));
    }

    @Test
    public void testInsertSetTime(){
        ISetAnalyzer  setInsertAnalyzer = new SetInsertAnalyzer();
        insertionTime = setInsertAnalyzer.insertionTime(set);
        System.out.println(insertionTime);
    }
    @Test
    public void testDeleteSetTime(){
        ISetAnalyzer  setDeleteAnalyzer = new SetDeleteAnalyzer();
        deletionTime = setDeleteAnalyzer.insertionTime(set);
        System.out.println(deletionTime);
    }
}
