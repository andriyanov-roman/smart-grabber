package smartgrabber.class_analyzer;

import org.junit.Test;
import sun.reflect.Reflection;

/**
 * Created by mit_OK! on 28.10.2015.
 */
public class TestClassAnalyzer {
    @Test
    public void runClassAnalyzation (){
        ClassAnalyzerImpl classAnalyzer = new ClassAnalyzerImpl();
        //classAnalyzer.setAnalyzedClass(Reflection.class);
        //classAnalyzer.setAnalyzedClass(String.class);
        //classAnalyzer.setAnalyzedClass(ClassAnalyzerImpl.class);
        classAnalyzer.setAnalyzedClass(Class.class);
        classAnalyzer.analyzeIt();
    }

}
