package smartgrabber.collection_analyzer.queues;


import java.util.Queue;


public class AddElement implements Executable{
private Queue queue;

    public AddElement(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void execute() {
        queue.add("fff");
    }


}
