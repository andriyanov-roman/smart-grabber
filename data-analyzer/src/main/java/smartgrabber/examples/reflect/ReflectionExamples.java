package smartgrabber.examples.reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by randriyanov on 30.07.15.
 */
public class ReflectionExamples {
    public static void main(String[] args) throws
            InvocationTargetException,
            IllegalAccessException,
            NoSuchFieldException,
            NoSuchMethodException {
        String clazz = int.class.getName();
        System.out.println(clazz);

        PrivateObject privateObject = new PrivateObject();

        Field privateStringField = PrivateObject.class.
                getDeclaredField("privateString");

        privateStringField.setAccessible(true);

        String fieldValue = (String) privateStringField.get(privateObject);
        System.out.println("fieldValue = " + fieldValue);
        Method method = PrivateObject.class.getDeclaredMethod("doSomething", String.class);
        method.setAccessible(true);
        Object parameter = "test";
        method.invoke(privateObject, parameter);
    }

    public static void testReflection() {
        File file = new File("home/randriyanov/Test.class");

        try {
            // Convert File to a URL
            URL url = file.toURL();          // file:/c:/myclasses/
            URL[] urls = new URL[]{url};

            // Create a new class loader with the directory
            ClassLoader cl = new URLClassLoader(urls);

            // Load in the class; MyClass.class should be located in
            // the directory file:/c:/myclasses/com/mycompany
            Class cls = cl.loadClass("randriyanov.Test");
            Method method = cls.getMethod("addNewElement");
            method.invoke(cls, null);
        } catch (MalformedURLException e) {
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
