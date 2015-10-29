package smartgrabber.class_analyzer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by mit_OK! on 28.10.2015.
 */
public class ClassAnalyzerImpl<T extends Class> implements IClassAnalyzer {
    private Class<T> analyzedClass;

    public Class<T> getAnalyzedClass() {
        return analyzedClass;
    }

    public void setAnalyzedClass(Class<T> analyzedClass) {
        this.analyzedClass = analyzedClass;
    }

    public ClassAnalyzerImpl(Class<T> analyzedClass) {
        this.analyzedClass = analyzedClass;
    }

    public ClassAnalyzerImpl() {
    }


    @Override
    public void analyzeIt() {
        if (analyzedClass != null) {
            analyzClassName();
            analyzeClassModifiers();
            analyzeInterfaces();
            analyzeFields();
            analyzeConstructors();
            analyzeMethods();
            analyzeAnnotations();
        } else {
            System.out.println("\t[ANALYZED CLASS NOT SET!]");
        }

    }

    private void analyzClassName() {
        System.out.println("Analyzed Class: " + analyzedClass.getSimpleName());
        System.out.println("Canonical Class Name: " + analyzedClass.getCanonicalName());
        System.out.println("Super Class: " + analyzedClass.getSuperclass());
    }

    private void analyzeClassModifiers() {
        int mods = analyzedClass.getModifiers();
        System.out.println("Modifiers:" + receiveModifiers(mods));

    }
    private String receiveModifiers(int mods){
        String modifiersStr = "";
        if (Modifier.isPublic(mods)) {
            modifiersStr += " public";
        }
        if (Modifier.isPrivate(mods)) {
            modifiersStr += " private";
        }
        if (Modifier.isAbstract(mods)) {
            modifiersStr +=" abstract";
        }
        if (Modifier.isFinal(mods)) {
            modifiersStr +=" final";
        }
        if (Modifier.isStatic(mods)) {
            modifiersStr +=" static";
        }
        if (Modifier.isProtected(mods)) {
            modifiersStr +=" protected";
        }
        if (Modifier.isSynchronized(mods)) {
            modifiersStr +=" synchronized";
        }
        return modifiersStr;
    }
    private void analyzeInterfaces() {
        System.out.print("Interface:");
        for (Class classInterface : analyzedClass.getInterfaces()) {
            System.out.print(" " + classInterface.getName() + ",");
        }
        System.out.println();
    }

    private void analyzeFields() {
        System.out.println("Fields (Type : Name):");
        Field[] publicFields = analyzedClass.getDeclaredFields();
        for (Field field : publicFields) {
            System.out.format("\t%1$2s : %2$2s\n", field.getType().getSimpleName(), field.getName());
        }
    }

    private void analyzeConstructors() {
        System.out.println("Constructors:");
        Constructor[] constructors = analyzedClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.println("\t" + constructor.getName() + " (" + paramType.getSimpleName() + " " +
                        paramType.getSimpleName().substring(0, 1).toLowerCase() + ")");
            }
        }
    }

    private void analyzeMethods() {
        System.out.println("Methods: ");
        Method[] methods = analyzedClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodModifiers = receiveModifiers(method.getModifiers());
            System.out.print("\t"+methodModifiers+" "+method.getName() + "(");
            Class[] paramTypes = method.getParameterTypes();
            String result = "";
            for (Class paramType : paramTypes) {
                result = result+paramType.getSimpleName() + ", ";
            }
            if (!result.equals("")) {
                System.out.print(result.substring(0, result.length() - 2));
            }
            System.out.println(") -- return " + method.getReturnType().getSimpleName());
        }
    }

    private void analyzeAnnotations() {
        System.out.println("Class Annotations: name / type");
        receiveAnnotationsStr(analyzedClass.getDeclaredAnnotations());
        System.out.println("\nMethods' Annotations: name / method");
        Method[] methods = analyzedClass.getDeclaredMethods();
        for (Method method : methods) {
            String annotStr = receiveAnnotationsStr(method.getDeclaredAnnotations());
            if (!annotStr.equals("")) {
                System.out.println(annotStr+" - " + method.getName() + "();");
            }
        }
    }
    private  String receiveAnnotationsStr(Annotation[] annotations){
        String annotStr = "";
        for (Annotation ann : annotations) {
            annotStr += " @"+ann.annotationType().getSimpleName();
        }
        return annotStr;
    }
}
