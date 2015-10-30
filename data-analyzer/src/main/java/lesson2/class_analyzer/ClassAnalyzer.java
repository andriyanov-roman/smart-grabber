package lesson2.class_analyzer;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * Created by R-Tem on 27.10.2015.
 */
public class ClassAnalyzer {

    private Class clazz;

    public ClassAnalyzer(String className) {
        try {
            this.clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception: There is no such class name!\n" +
                    "Try again, please, e.g. java.lang.String");
        }
    }

    public ClassAnalyzer(Object obj) {
        this.clazz = obj.getClass();
    }

    public void analyze(String s) {
        switch (s) {
            case "-all":
                obtainClassInfo();
                obtainInterfaces();
                obtainFields();
                obtainConstructors();
                obtainMethods();
                obtainAnnotations();
                break;
            case "-cls":
                obtainClassInfo();
                break;
            case "-fld":
                obtainFields();
                break;
            case "-ctr":
                obtainConstructors();
                break;
            case "-mtd":
                obtainMethods();
                break;
            default:
                break;
        }
    }

    private void obtainClassInfo() {
        System.out.println("Class Simple Name:      " + clazz.getSimpleName());
        System.out.println("Class Canonical Name: " + clazz.getCanonicalName());
        System.out.println("super:           " + clazz.getSuperclass());
        System.out.println("is interface:    " + clazz.isInterface());
        System.out.println("is serializable: " + Serializable.class.isAssignableFrom(clazz));
        System.out.println("is primitive:    " + clazz.isPrimitive());
        System.out.println("is number:       " + Number.class.isAssignableFrom(clazz));
        System.out.println("modifier:        " + printModifiers(clazz.getModifiers()));
    }

    private void obtainInterfaces() {
        System.out.print("Interfaces impl:");
        for (Class classInterface : clazz.getInterfaces()) {
            System.out.print(" " + classInterface.getName() + ",");
        }
        System.out.println();
    }

    private void obtainFields() {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fields: ");
        for (int i = 0; i < fields.length; i++) {
            System.out.println("\t" + printModifiers(fields[i].getModifiers())
                    + fields[i].getType().getSimpleName() + " " + fields[i].getName());
        }
    }

    private void obtainConstructors() {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("constructors: ");
        for (int i = 0; i < constructors.length; i++) {
            Class[] paramTypes = constructors[i].getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.println("\t" + printModifiers(constructors[i].getModifiers())
                        + constructors[i].getName() + " ("
                        + paramType.getSimpleName() + " "
                        + paramType.getSimpleName().substring(0, 1).toLowerCase() + ")");
            }
        }
    }

    private void obtainMethods() {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("methods: ");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(printAnnotation(methods[i].getDeclaredAnnotations()));
            System.out.print("\t" + printModifiers(methods[i].getModifiers())
                    + methods[i].getReturnType().getSimpleName() + " "
                    + methods[i].getName() + "(");
            Class[] paramTypes = methods[i].getParameterTypes();
            String result = "";
            for (Class paramType : paramTypes) {
                result = result + paramType.getSimpleName() + ", ";
            }
            if (!result.equals("")) {
                System.out.print(result.substring(0, result.length() - 2));
            }
            System.out.println(")");
        }
    }

    private void obtainAnnotations() {
    }

    private String printModifiers(int modifier) {
        String s = "";
        if (Modifier.isPrivate(modifier)) {
            s = s + "private ";
        }
        if (Modifier.isProtected(modifier)) {
            s = s + "protected ";
        }
        if (Modifier.isPublic(modifier)) {
            s = s + "public ";
        }
        if (Modifier.isAbstract(modifier)) {
            s = s + "abstract ";
        }
        if (Modifier.isFinal(modifier)) {
            s = s + "final ";
        }
        if (Modifier.isNative(modifier)) {
            s = s + "native ";
        }
        if (Modifier.isInterface(modifier)) {
            s = s + "interface ";
        }
        if (Modifier.isStatic(modifier)) {
            s = s + "static ";
        }
        if (Modifier.isStrict(modifier)) {
            s = s + "strict ";
        }
        if (Modifier.isSynchronized(modifier)) {
            s = s + "synchronized ";
        }
        if (Modifier.isTransient(modifier)) {
            s = s + "transient ";
        }
        if (Modifier.isVolatile(modifier)) {
            s = s + "volatile ";
        }
        return s;
    }

    private String printAnnotation(Annotation[] annotations) {
        String s = "";
        for (Annotation ann : annotations) {
            s += "@" + ann.annotationType().getSimpleName() + " ";
        }
        return s;
    }
}
