package lesson2;

import lesson2.immutable_objects.ImmutableKey;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by R-Tem on 26.10.2015.
 */
public class TestMyImmutable {

    int num = 123;
    ImmutableKey immutableKey;
    Map map;

    @Test
    public void testInMap () {
        map = new HashMap<ImmutableKey, String>();

        List arrayList = new ArrayList<>();
        arrayList.add("Alisa");
        arrayList.add(num);

        immutableKey = new ImmutableKey(5, "Roman", new Date(2015, 10, 24), arrayList);

        map.put(immutableKey, "Hallo World!!!");
        writeToConsole();
        Assert.assertEquals(map.get(immutableKey), "Hallo World!!!");

        immutableKey.getList().set(0, "Dima");
        writeToConsole();
        Assert.assertEquals(map.get(immutableKey), "Hallo World!!!");

        immutableKey.getDate().setTime(num);
        writeToConsole();
        Assert.assertEquals(map.get(immutableKey), "Hallo World!!!");

    }

    void writeToConsole(){
        System.out.println(map.get(immutableKey) + " HashCod: " + immutableKey.hashCode());
        for (int i = 0; i < immutableKey.getList().size(); i++) {
            System.out.println(immutableKey.getList().get(i));
        }
    }
}
