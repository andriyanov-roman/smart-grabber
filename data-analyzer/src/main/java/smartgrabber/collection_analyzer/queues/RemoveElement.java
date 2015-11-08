package smartgrabber.collection_analyzer.queues;

import java.util.Queue;


public class RemoveElement implements Executable {
    private Queue queue;

    public RemoveElement(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void execute() {
        queue.remove(" ");
    }
}
