package jaxrs;


import jaxrs.logging.SimpleMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    final static Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        new SimpleMethods().doSomething();
        int i = 461012;
        System.out.format("The value of i is: %d%n", i);
    }
}
