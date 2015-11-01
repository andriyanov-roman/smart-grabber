package smartgrabber.collection_analyzer;

import org.junit.Test;

import java.util.*;

import smartgrabber.collection_analyzer.queues.IQueueAnalyzer;
import smartgrabber.collection_analyzer.queues.QueueImpl;
/**
 * by Aliso4ka1313 on 30.10.2015.
 */
public class QueueImplTest {

    @Test
    public void findMemoryTest() {
        IQueueAnalyzer<Queue> analyzer = new QueueImpl();
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
            IQueueAnalyzer<Queue> analyzer = new QueueImpl();
            Deque<String> deque = new ArrayDeque<>();
            deque.add("aaaa");
            deque.add("bbb");
            deque.add("ccc");
            deque.add("dd");
            deque.add("e");

            System.out.println(analyzer.findTime(deque));

    }
}
