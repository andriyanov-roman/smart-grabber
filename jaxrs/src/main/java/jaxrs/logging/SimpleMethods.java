package jaxrs.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleMethods {
    final static Logger logger = LogManager.getRootLogger();

    public void doSomething() {
        logger.info("Test in SimpleMethods");
        System.out.println("test");
    }

}
