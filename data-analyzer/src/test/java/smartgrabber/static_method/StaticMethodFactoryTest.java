package smartgrabber.static_method;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by randriyanov on 08.11.15.
 */
public class StaticMethodFactoryTest {

    @Test
    public void testFirst() {
        BigInteger integer = MyBigInteger.getRandomBigInteger(10, 20, new Random());
        if(Boolean.valueOf(true) == Boolean.valueOf(true)) {
            System.out.println("true");
        }
        Set<String> stringSet = Collections.newSetFromMap(new HashMap<>());
        HashMap<String, List<String>> map = newInstance();
    }

    public static <K, V> HashMap<K,V> newInstance() {
        return new HashMap<>();
    }

    private static class MyBigInteger {

        public static BigInteger getRandomBigInteger(int bitLength,
                                                     int certainty,
                                                     Random random) {
            return new BigInteger(bitLength, certainty, random);
        }


    }
}
