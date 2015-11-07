package smartgrabber.entity_SQLyzer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class TestEntitySQLyzerImpl {
    public static final String SQL_TO_TEST = "INSERT INTO `employees` (`surname`, `position`, `sql_name`, `maleGender`, `age`) VALUES (\"Petrov\", \"Manager\", \"Ivan\", \"true\", \"35\")";
    private IEntitySQLyzer slqAnalyzer;

    @BeforeClass
    public void before() {
        slqAnalyzer = new EntitySQLyzerImpl();
    }

    @Test
    public void transformIntoSQLQuery() {
        Employee employee = new Employee("Ivan", "Petrov",EmployPosition.Manager,35,true);
        DataBaseTable table = new DataBaseTable() {
            @Override
            public boolean equals(Object obj) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String value() {
                return null;
            }
        };
        slqAnalyzer.createInsertQuery(employee, table);
        Assert.assertEquals(SQL_TO_TEST, slqAnalyzer.createInsertQuery(employee, table));
    }
}
