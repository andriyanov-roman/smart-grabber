package smartgrabber.cloneobject;

import java.util.*;
import static org.junit.Assert.*;

/**
 * Created by mit_OK! on 25.10.2015.
 */
public class ImmutableExampleMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList testArrayList = new ArrayList(Arrays.asList("one","two", "three"));
        MyImmutableObject object = new MyImmutableObject(new Date(),testArrayList);
        Map<MyImmutableObject, String> map = new HashMap<>();
        map.put(object, "A");
        assertEquals(map.get(object), "A");
        System.out.println(object.hashCode());
        object.getArrayList().add("B");

        object.getDate().setTime(100000L);
        assertEquals(map.get(object), "A");
        System.out.println(object.hashCode());
    }
}
