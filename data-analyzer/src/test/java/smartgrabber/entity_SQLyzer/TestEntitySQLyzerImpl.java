package smartgrabber.entity_SQLyzer;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

/**
 * Created by mit_OK! on 06.11.2015.
 */
public class TestEntitySQLyzerImpl implements IEntitySQLyzer{

    @Override
    public String createInsertQuery(Employee employee) {
        String query = "INSERT INTO";
        String quoteForKey = "`";
        String quoteForValue = "\"";
        DataBaseTable table = employee.getClass().getAnnotation(DataBaseTable.class);
        Assert.assertNotNull("@DataBaseTable annotation isn't defined", table);
        query += " "+quoteForKey+table.value()+quoteForKey;
        Map<String,Object> map = new HashMap<>();
        for (Field field : employee.getClass().getDeclaredFields()) {
            String columnKey = null;
            String annoValue = field.getAnnotation(DataBaseTextColumn.class).value();
            if (!annoValue.equals("")) {
                columnKey = annoValue;
            }
            Object columnValue = null;
            field.setAccessible(true);
            try {
                columnValue = field.get(employee);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            map.put(columnKey,columnValue);
        }
        String queryKeys = map.keySet()
                .stream()
                .map(Object::toString)
                .collect(joining(quoteForKey+", "+quoteForKey, quoteForKey, quoteForKey));
        String queryValues = map.values()
                .stream()
                .map(Object::toString)
                .collect(joining(quoteForValue+", "+quoteForValue, quoteForValue, quoteForValue));
        query += " (" + queryKeys+") VALUES (" + queryValues + ")";
        return query;
    }

    @Test
    public void transformIntoSQLQuery () {
        Employee employee = new Employee("Ivan", "Petrov",EmployPosition.Manager,35,true);
        System.out.println(createInsertQuery(employee));
        String  template = "INSERT INTO `employees` (`surname`, `position`, `sql_name`, `maleGender`, `age`) VALUES (\"Petrov\", \"Manager\", \"Ivan\", \"true\", \"35\")";
        Assert.assertEquals(template, createInsertQuery(employee));
    }
}
