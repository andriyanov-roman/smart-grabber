package smartgrabber.examples.collectionanalyzer;



import smartgrabber.examples.collectionanalyzer.SimpleTest;
import smartgrabber.examples.collectionanalyzer.examples.CarMoveImpl;
import smartgrabber.examples.collectionanalyzer.examples.IMove;
import smartgrabber.examples.collectionanalyzer.examples.PlaneMoveImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!!!!!");
        SimpleTest test = new SimpleTest();
        IMove car = new CarMoveImpl();
        test.getMove(car);
        IMove plane = new PlaneMoveImpl();
        test.getMove(plane);
    }
}
