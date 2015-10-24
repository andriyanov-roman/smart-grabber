package smartgrabber;


import smartgrabber.collect.examples.CarMoveImpl;
import smartgrabber.collect.examples.IMove;
import smartgrabber.collect.examples.PlaneMoveImpl;
import smartgrabber.collect.SimpleTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello !!!!!");
        SimpleTest test = new SimpleTest();
        IMove car = new CarMoveImpl();
        test.getMove(car);
        IMove plane = new PlaneMoveImpl();
        test.getMove(plane);
    }
}
