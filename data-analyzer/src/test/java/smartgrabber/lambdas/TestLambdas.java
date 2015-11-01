package smartgrabber.lambdas;


import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLambdas {

    private Map<String, String> map = new HashMap<>();

    @Before
    public void before() {
        map.put("A","B");
        map.put("C","D");
    }
}
