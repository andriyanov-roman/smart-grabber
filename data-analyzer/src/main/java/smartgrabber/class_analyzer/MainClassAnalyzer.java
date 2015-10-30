package smartgrabber.class_analyzer;

/**
 * Created by mit_OK! on 29.10.2015.
 */
public class MainClassAnalyzer {
    public static void main(String[] args) {
        ClassAnalyzerImpl classAnalyzer = new ClassAnalyzerImpl();
        classAnalyzer.setAnalyzedClass(Class.class);
        classAnalyzer.analyzeIt();
    }
}
