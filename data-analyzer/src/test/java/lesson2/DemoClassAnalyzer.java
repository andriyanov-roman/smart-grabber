package lesson2;

import lesson2.class_analyzer.ClassAnalyzer;
import lesson2.method_invoker.MethodInvoker;

import java.util.Scanner;

/**
 * Created by R-Tem on 27.10.2015.
 */
public class DemoClassAnalyzer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hallo!\n" +
                "Enter the class name, e.g. java.lang.String\n" +
                "or Create object, e.g. Object obj = new String()"); // TODO
        String s = in.next();
        ClassAnalyzer classAnalyzer = new ClassAnalyzer(s);

        System.out.println("usage: -all, -cls, -fld, -ctr, -mtd");
        classAnalyzer.analyze(in.next());

        System.out.print("\n example of 'split' method invocation: \n");
        MethodInvoker methodInvoker = new MethodInvoker("q w e r t y", "split", String.class, " ");
        String[] strings = (String[]) methodInvoker.invoke();
        for (String string:strings) {
            System.out.println(string);
        }
    }
}