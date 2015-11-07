package smartgrabber.collection_analyzer;

import org.junit.Test;
import smartgrabber.collection_analyzer.lists.ArrayListAnalyzerOLD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by R-Tem on 04.11.2015.
 */
public class ListOperationsAnalyzer {

    @Test
    public void listCreationTime() {
        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        List list = new ArrayList<>();
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        List list1 = new ArrayList<>();
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        List list2 = new ArrayList<>();
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);

        startTime = System.nanoTime();
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
    }

    @Test
    public void insertionTime() {
        ArrayList arrayList = new ArrayList();
        ArrayListAnalyzerOLD analyzer = new ArrayListAnalyzerOLD();
        System.out.println("For adding of 1 000 000 Strings into ArrayList you need: " + analyzer.insertionTime(arrayList) + " nanoSec.");
    }

    @Test
    public void addingTime() {

        ArrayList arrayList = new ArrayList();
        ArrayListAnalyzerOLD analyzer = new ArrayListAnalyzerOLD();
        System.out.println("To add 1 Object into ArrayList you need: " + analyzer.insertionTime(arrayList, "TEST_STRING") + " nanoSec.");
    }

    @Test
    public void addingAllTime() {

        int arraySize = 1000000;
        List insArrayList = new LinkedList<>();
        for (int i = 0; i < arraySize; i++) {
            insArrayList.add("TEST_STRING");
        }

        ArrayList arrayList = new ArrayList();
        ArrayListAnalyzerOLD analyzer = new ArrayListAnalyzerOLD();

        System.out.println("To add an array of " + arraySize + " Objects into ArrayList you need: "
                + analyzer.insertionTime(arrayList, insArrayList) + " nanoSec.");
    }

    @Test
    public void addingToStart() {

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            arrayList.add("TEST_STRING");
        }
        ArrayListAnalyzerOLD analyzer = new ArrayListAnalyzerOLD();

        System.out.println("To add 1 Object into beginning of ArrayList you need: " + analyzer.insertionTime(arrayList, "TEST_STRING", 0) + " nanoSec.");
    }

    @Test
    public void addingInside() {

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 9; i++) {
            arrayList.add("TEST_STRING");
        }
        ArrayListAnalyzerOLD analyzer = new ArrayListAnalyzerOLD();

        System.out.println("To add 1 Object inside of ArrayList you need: " + analyzer.insertionTime(arrayList, "TEST_STRING", 3) + " nanoSec.");

    }

    @Test
    public void removeTime() {

    }

    @Test
    public void removeAllTime() {

    }

    @Test
    public void removeFromStart() {

    }

    @Test
    public void removeFromEnd() {

    }

    @Test
    public void removeFromInside() {

    }

    @Test
    public void clearTime() {

    }

    @Test
    public void listCapacity() {

    }
}