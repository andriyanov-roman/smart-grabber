package smartgrabber.collection_analyzer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import smartgrabber.collection_analyzer.queues.IQueueAnalyzer;
import smartgrabber.collection_analyzer.queues.QueueAnalyzerImpl;
/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public class QueueAnalyzerImplTest {
    IQueueAnalyzer<Queue> analyzer = new QueueAnalyzerImpl();
    Deque<String> deque = new ArrayDeque<>();
    @BeforeClass
    public void before(){
        deque.add("aaaa");
        deque.add("bbb");
        deque.add("ccc");
        deque.add("dd");
        deque.add("e");
    }

    @Test
    public void findMemoryTest(){
        System.out.println(analyzer.findMemory(deque) + " bytes");
    }
   /* @Test
    public void findMemoryTest() {
        IQueueAnalyzer<Queue> analyzer = new QueueAnalyzerImpl();
        Deque<String> deque = new ArrayDeque<>();
        deque.add("aaaa");
        deque.add("bbb");
        deque.add("ccc");
        deque.add("dd");
        deque.add("e");

        System.out.println(analyzer.findMemory(deque) + " bytes");
    }
        @Test
        public void findTimeTest(){
            IQueueAnalyzer<Queue> analyzer = new QueueAnalyzerImpl();
            Deque<String> deque = new ArrayDeque<>();
            deque.add("aaaa");
            deque.add("bbb");
            deque.add("ccc");
            deque.add("dd");
            deque.add("e");

            System.out.println(analyzer.findTime(deque));

    }*/
}
