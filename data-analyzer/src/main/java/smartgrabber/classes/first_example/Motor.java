package smartgrabber.classes.first_example;

//Если внутренний класс наследуется обычным образом другим классом (по-
//        сле extends указывается ИмяВнешнегоКласса.ИмяВнутреннегоКласса), то  он
//        теряет доступ к полям своего внешнего класса, в котором был объявлен.
public class Motor extends Ship.Engine {

    public Motor(Ship obj) {
        obj.super();
    }
}
