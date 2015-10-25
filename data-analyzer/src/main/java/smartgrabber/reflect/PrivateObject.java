package smartgrabber.reflect;


public class PrivateObject {
    private String privateString = "Something";

    @MyAnnotation(value = 10)
    private void doSomething(String str) {
        System.out.println("Hello world " + str);
    }
}
