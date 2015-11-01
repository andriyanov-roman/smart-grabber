package smartgrabber.examples.reflect;

import java.lang.reflect.Method;

/**
 * Created by randriyanov on 30.07.15.
 */
public class TestAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {
        SimpleMethods simpleMethods = new SimpleMethods();
        Class clazz = simpleMethods.getClass();

        Method method = clazz.getMethod("addNewElement");
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
        System.out.println(myAnnotation.columnName());
    }
}
