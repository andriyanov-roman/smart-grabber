package smartgrabber.examples.reflect;

@MyTable(
        @MyAnnotation(value = 2, columnName = "test")
)
public class SimpleMethods {

    @MyAnnotation(value = 10, columnName = "test_column")
    public void doSomething() {
        System.out.println("test");
    }
}
