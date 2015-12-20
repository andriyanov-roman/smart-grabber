package examples.view;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorldBean {

    public HelloWorldBean() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World!";
    }
}
