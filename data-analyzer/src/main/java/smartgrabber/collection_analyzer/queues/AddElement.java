package smartgrabber.collection_analyzer.queues;

import java.util.Collection;
import java.util.Queue;

/**
 * Created by Администратор on 07.11.2015.
 */
public class AddElement extends Operation implements Executable{
    @Override
    public void execute(Queue queue) {
        queue.add("fff");
    }


}
