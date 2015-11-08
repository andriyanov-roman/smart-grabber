package smartgrabber.collection_analyzer.lists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by mit_OK! on 08.11.2015.
 */
public class TestArrayListExplorer {
    ArrayListAnalyzer<String> analyzer;
    public static final String CONTROL_TEMPLATE = "I'm added!";
    public static final int CONTROL_ARRAYLIST_SIZE = 2_000_000;
    public static final Long CONTROL_MEMORY_SIZE = 76781992L;
    ArrayList<String> analyzedList;
    ArrayList<String> additionalList;

    @Before
    public void initArrayList() {
        analyzedList = new ArrayList<>();
        additionalList = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            analyzedList.add(i+"_element");
            additionalList.add(i+"_sub");
        }
        analyzer = new ArrayListAnalyzer<>(analyzedList);

    }

    @Test
    public void exploreTimeOfOneElementAdd () {
        ArrayListAnalyzer<String>.OneElementAdder oneElementAdder = analyzer.new OneElementAdder(CONTROL_TEMPLATE);
        Long spendTime = analyzer.retrieveExecutionTime(oneElementAdder);
        String actualElement = analyzer.getList().get(analyzer.getList().size()-1);
        Assert.assertEquals("Equals test... ", CONTROL_TEMPLATE,actualElement);
        System.out.println("Spended time: " + spendTime/Math.pow(10,6) +" ms");
    }

    @Test
    public void exploreTimeOfMillionElementsAdd () {
        ArrayListAnalyzer<String>.ManyElementsAdder oneElementAdder = analyzer.new ManyElementsAdder(additionalList);
        Long spendTime = analyzer.retrieveExecutionTime(oneElementAdder);
        int actualSize = analyzer.getList().size();
        Assert.assertEquals("Equals test... ", CONTROL_ARRAYLIST_SIZE,actualSize);
        System.out.println("Spended time: " + spendTime/Math.pow(10,9) +" seconds");
    }

    @Test
    public void showMemoryUsage (){
        Long actualSize = analyzer.retrieveUsedMemory();
        Assert.assertEquals("Equals test... ", CONTROL_MEMORY_SIZE,actualSize);
        System.out.println("Memory used: "+actualSize);
    }
}
