package smartgrabber.examples.collectionanalyzer.examples;

/**
 * Created by randriyanov on 24.10.15.
 */
public class CarMoveImpl implements IMove {

    private PlaneMoveImpl planeMove = new PlaneMoveImpl();

    public String move() {
        return "now I am car";
    }

    public String fly() {
        return planeMove.fly();
    }
}
