package smartgrabber;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Created by randriyanov on 31.10.15.
 */
public class PropertiesTest {

    @Test
    public void testProperties() throws Exception {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/test/resources/application-ru.properties");
        property.load(fis);

        String book = property.getProperty("book");
        String dog = property.getProperty("dog");
        System.out.println(book);
        System.out.println(dog);

    }

}
