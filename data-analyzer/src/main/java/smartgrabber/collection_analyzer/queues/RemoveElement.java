package smartgrabber.collection_analyzer.queues;

import java.util.Collection;
import java.util.Queue;

/**
 * Created by Администратор on 07.11.2015.
 */
public class RemoveElement extends Operation implements Executable {
    @Override
    public void execute(Queue queue) {
        queue.remove(" ");
    }
}
