package smartgrabber.collection_analyzer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import smartgrabber.collection_analyzer.queues.AddElement;
import smartgrabber.collection_analyzer.queues.IQueueAnalyzer;
import smartgrabber.collection_analyzer.queues.QueueAnalyzerImpl;
import smartgrabber.collection_analyzer.queues.RemoveElement;


/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public class QueueAnalyzerImplTest {
    IQueueAnalyzer<Queue> analyzer = new QueueAnalyzerImpl();
    private static Deque<String> deque = new ArrayDeque<>();

    @BeforeClass
    public static void before() {
        deque.add("aaaa");
        deque.add("bbb");
        deque.add("ccc");
        deque.add("dd");
        deque.add("e");
    }

    @Test
    public void findMemoryTest() {
        System.out.println(analyzer.findMemory(deque) + " bytes");
    }


    @Test
    public void findTimeTest() {
        AddElement addElement = new AddElement(deque);
        RemoveElement removeElement = new RemoveElement(deque);
        System.out.println(analyzer.findTime(addElement));
        System.out.println(analyzer.findTime(removeElement));

    }
}
