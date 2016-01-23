package com.empl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by faust on 23.01.16.
 */
@ContextConfiguration(classes = Main.class)
@ComponentScan("com.empl")
@PropertySource("classpath:/com/empl/empl.properties")
public class Main {
    /*@Autowired
    private Environment env;*/

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Environment env = context.getEnvironment();
        Employee employee = (Employee) context.getBean("employee-component");
        String test = env.getProperty("employee.name");
        System.out.println(test);
        System.out.println(employee.getSurname());
    }
}
