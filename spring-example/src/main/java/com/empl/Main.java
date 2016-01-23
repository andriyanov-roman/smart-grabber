package com.empl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Created by faust on 23.01.16.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Environment environment = context.getBean(Environment.class);
        String test = environment.getProperty("employee.name");
        Employee e = context.getBean(Employee.class);
        System.out.println(test);
    }

}
