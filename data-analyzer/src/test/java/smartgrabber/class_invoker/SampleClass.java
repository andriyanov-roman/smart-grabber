package smartgrabber.class_invoker;

import java.util.ArrayList;

/**
 * Created by mit_OK! on 29.10.2015.
 */
public class SampleClass {
    private String testField;

    public void test(Integer integer){
        System.out.println("I'm FIRST method. Result: "+integer);
    }
    public void test(Double d) {
        System.out.println("I'm SECOND method. Result: "+d);
    }
    public void test(ArrayList arrayList) {
        System.out.println("I'm THIDR method. Result: "+arrayList);
    }
    public void test(SampleClass sampleClass) {
        System.out.println("I'm 4th method. Result: "+sampleClass);
    }
    public void test(Integer integer, Double d){
        System.out.println("I'm 5th method. Result: "+integer+" "+d);
    }
}
