package smartgrabber;

import smartgrabber.analyzer.DbTextRetrieval;

/**
 * Created by randriyanov on 24.10.15.
 */
public class Main {
    public static void main(String[] args) {
        DbTextRetrieval retrieval = new DbTextRetrieval();
        String textOne = "Test";
        retrieval.analyzeText(textOne);
        String textTwo = "Hello";
        retrieval.analyzeText(textTwo);
    }
}
