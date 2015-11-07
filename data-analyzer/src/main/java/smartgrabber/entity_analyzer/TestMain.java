package smartgrabber.entity_analyzer;

import java.lang.annotation.Annotation;

/**
 * Created by mit_OK! on 01.11.2015.
 */
public class TestMain {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setId(55L);
        e.setName("Ivan");

        Annotation[] ann = Employee.class.getDeclaredAnnotations();
        for (int i = 0; i < ann.length; i++) {
        }
        //INSERT INTO `employee`(`id`, 'sql_name' , `surname`) VALUES ([value-1],e.getName(),[value-3])

    }
}
