package smartgrabber.analyzer;


import smartgrabber.examples.logic.TextAnalyzerImpl;

public class DbTextRetrieval {


    public void analyzeText(String text) {
        TextAnalyzerImpl analyzer = new TextAnalyzerImpl();
        System.out.println(analyzer.isTextApplicable(text));
    }
}
