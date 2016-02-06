package smartgrabber.classes.first_example;


public class Ship {

    private Engine eng;


    public class Engine {

        public void launch() {
            System.out.println("Запуск двигателя");
        }
    }

    public final void init() {
        eng = new Engine();
        eng.launch();
    }
}
