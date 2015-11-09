package smartgrabber.classes.first_example;


public class FirstMain {
    public static void main(String[] args) {
        Ship.Engine obj = new Ship().new Engine();
        obj.launch();
        Ship ship = new Ship();
        Ship.Engine engine = ship.new Engine();
    }
}