package lesson2;

import lesson2.class_analyzer.ClassAnalyzer;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by R-Tem on 27.10.2015.
 */
public class DemoClassAnalyzer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hallo!\n" +
                "Enter the class name, e.g. java.lang.String\n" +
                "or Create object, e.g. Object obj = new String()");
        String s = "java.lang.String"; // in.next()
        ClassAnalyzer classAnalyzer = new ClassAnalyzer(s);

        System.out.println("usage: -all, -cls, -fld, -ctr, -mtd");
        classAnalyzer.analyze("-all"); // in.next()
    }
}

