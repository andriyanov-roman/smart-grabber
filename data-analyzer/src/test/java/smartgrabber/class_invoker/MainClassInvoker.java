package smartgrabber.class_invoker;

import smartgrabber.class_analyzer.ClassAnalyzerImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Created by mit_OK! on 29.10.2015.
 */
public class MainClassInvoker {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassInvokerImpl classInvoker = new ClassInvokerImpl();
        classInvoker.setExploredClass(SampleClass.class);
        classInvoker.printDeclaredMethods();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type invoked method name: ");
        String nameOfInvokedMethod = "test";//scanner.next();
        classInvoker.invokeMethod(nameOfInvokedMethod);


    }
}
