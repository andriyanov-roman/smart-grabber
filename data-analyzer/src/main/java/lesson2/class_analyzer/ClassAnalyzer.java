package lesson2.class_analyzer;


import java.io.Serializable;
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
                obtainFields();
                obtainConstructors();
                obtainMethods();
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

    private void obtainClassInfo(){
        System.out.println("class name:      " + clazz.getName());
        System.out.println("super:           " + clazz.getSuperclass());
        System.out.println("is interface:    " + clazz.isInterface());
        System.out.println("is serializable: " + Serializable.class.isAssignableFrom(clazz));
        System.out.println("is primitive:    " + clazz.isPrimitive());
        System.out.println("is number:       " + Number.class.isAssignableFrom(clazz));
        System.out.println("modifier:        " + printModifiers(clazz));
    }

    private void obtainFields(){
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fields: ");
        for (int i = 0; i < fields.length; i++) {
            System.out.println("\t" + fields[i]);
        }
    }

    private void obtainConstructors(){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println("constructors: ");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("\t" + constructors[i]);
        }
    }

    private void obtainMethods(){
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("methods: ");
        for (int i = 0; i < methods.length; i++) {
            System.out.println("\t" + methods[i] + " declared by "
                    + methods[i].getDeclaringClass());
        }
    }

    private String printModifiers( Class dataType) {
        final int modifiers = dataType.getModifiers();
        if (Modifier.isPrivate(modifiers)) {
            return "private";
        }
        if (Modifier.isProtected(modifiers)) {
            return "protected";
        }
        if (Modifier.isPublic(modifiers)) {
            return "public";
        }
        if (Modifier.isAbstract(modifiers)) {
            return "abstract ";
        }
        if (Modifier.isFinal(modifiers)) {
            return "final ";
        }
        if (Modifier.isNative(modifiers)) {
            return "native ";
        }
        if (Modifier.isInterface(modifiers)) {
            return "interface ";
        }
        if (Modifier.isStatic(modifiers)) {
            return "static ";
        }
        if (Modifier.isStrict(modifiers)) {
            return "strict ";
        }
        if (Modifier.isSynchronized(modifiers)) {
            return "synchronized ";
        }
        if (Modifier.isTransient(modifiers)) {
            return "transient ";
        }
        if (Modifier.isVolatile(modifiers)) {
            return "volatile ";
        }
        return null;
//        System.out.println(dataType.getName());
    }
}
