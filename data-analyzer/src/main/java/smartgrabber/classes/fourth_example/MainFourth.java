package smartgrabber.classes.fourth_example;


public class MainFourth {
    public static void main(String[] args) {
        int i = 10;
        String str = "Test";
        //IDoSomething interfaceDoSomething = (str1, i1) -> System.out.println(i1 * i1);
        //interfaceDoSomething.doSomething(str, 10);
        //IDoSomething iDoSomething = ()
        IDoSomething interfaceDoSomething = (str1, i1) -> {
            if (i1 > 10) {
                System.out.println(true);
            }
            System.out.println(str1);
        };
        doSomething(interfaceDoSomething, "test", 10);
    }


    public static void doSomething(IDoSomething doSomething, String str, int i) {
        doSomething.doSomething(str, i);
    }
}
