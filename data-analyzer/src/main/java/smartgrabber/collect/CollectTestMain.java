package smartgrabber.collect;

import java.util.*;

/**
 * Created by randriyanov on 25.10.15.
 */
public class CollectTestMain {
    public static void main(String[] args) {
        ITimeAnalyzer<Map> analyzer = new MapAnalyzer();
        analyzer.findTime(new HashMap<>());
        analyzer.findTime(new LinkedHashMap<>());
        analyzer.findTime(new TreeMap<>());
        looksTime(analyzer);
    }

    public static <T extends Map>  void looksTime(ITimeAnalyzer<T> analyzer) {

    }
}
