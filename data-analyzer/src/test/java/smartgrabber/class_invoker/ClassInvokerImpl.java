package smartgrabber.class_invoker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by mit_OK! on 29.10.2015.
 */
public class ClassInvokerImpl<T> implements IClassInvoker {
    public static final String DEFAULT = "default";
    private Class<T> exploredClass;

    public ClassInvokerImpl(Class<T> exploredClass) {
        this.exploredClass = exploredClass;
    }

    public ClassInvokerImpl() {
    }

    public Class<T> getExploredClass() {
        return exploredClass;
    }

    public void setExploredClass(Class<T> exploredClass) {
        this.exploredClass = exploredClass;
    }

    private String stringifyParam(Class paramClass) {
        return paramClass.getSimpleName() + " " +
                paramClass.getSimpleName().toLowerCase().charAt(0);
    }

    private String retrieveMethodInStrForm(Method method) {
        String methodStr = "\t" + method.getName() + "(";
        String parameters = "";
        for (Class paramClass : method.getParameterTypes()) {
            parameters += stringifyParam(paramClass) + ", ";
        }
        if (!parameters.equals("")) {
            parameters = parameters.substring(0, parameters.length() - 2);
        }
        return methodStr + parameters + ");";
    }

    public void printDeclaredMethods() {
        for (Method method : exploredClass.getDeclaredMethods()) {
            System.out.println(retrieveMethodInStrForm(method));
        }
    }

    public void prepareInvoking() {

    }
    private Method specifyInvokedMethod (ArrayList<Method> methodVariations) throws NoSuchMethodException {
        Method invokedMethod;
        if (methodVariations.size() > 1) {
            System.out.println("Select method variation:");
            for (int i = 0; i < methodVariations.size(); i++) {
                System.out.println((i + 1) + ". " + retrieveMethodInStrForm(methodVariations.get(i)));
            }
            int selector = Integer.parseInt(new Scanner(System.in).next()) - 1;
            if (selector > methodVariations.size()) {
                throw new NoSuchMethodException();
            } else {
                invokedMethod = methodVariations.get(selector);
            }
        } else {
            invokedMethod = methodVariations.get(0);
        }
        return invokedMethod;
    }
    private Object[] specifyParametrsForInvMethod (Method invokedMethod) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Specify parameters (type '"+DEFAULT+"' to use Default Constructor on your own risk!):");
        Object[] args = new Object[invokedMethod.getParameterCount()];
        for (int i = 0; i < invokedMethod.getParameterCount(); i++) {
            Class currentParameter = invokedMethod.getParameterTypes()[i];
            String paramKey = stringifyParam(currentParameter);
            System.out.print(paramKey + ": ");
            Constructor paramConstructor = null;
            Boolean resultIsFind = false;
            String unresolvedParamValue = new Scanner(System.in).next();
            if (unresolvedParamValue.equals(DEFAULT)) {
                try {
                    paramConstructor = currentParameter.getConstructor(null);
                } catch (NoSuchMethodException e) {
                    System.out.println("\n\t\t>>>" + currentParameter.getName() + " DOESN'T HAVE EMPTY CONSTRUCTOR!\n");
                    System.out.println("\t\t>>> I WARNED !!!\n\n ");
                    e.printStackTrace(System.out);
                    return null;
                }
                args[i] = paramConstructor.newInstance(new Object[]{});
                break;
            } else {
                System.out.print("\t\t\tSearching for default STRING constructor");
                for (Constructor constructor : currentParameter.getConstructors()) {
                    for (Class constructorParamType : constructor.getParameterTypes()) {
                        System.out.print(".");
                        if (constructorParamType.getCanonicalName().equals("java.lang.String")) {
                            paramConstructor = constructor;
                            resultIsFind = true;
                            System.out.print("\n\t [" + paramConstructor.getName()+"(String s)]");
                            break;
                        }
                    }
                    if (resultIsFind) {
                        System.out.println("\t\tGot it!");
                        break;
                    }
                }
            }
            if (!resultIsFind) {
                throw new NoSuchElementException("\nCan't create PARAMETER [" + paramKey + "] for method invoking");
            } else {
                Object paramValue = paramConstructor.newInstance(unresolvedParamValue);
                args[i] = paramValue;
            }
        }
        return args;
    }
    public void invokeMethod(String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<Method> methodVariations = receiveMethodVariations(methodName);
        Method invokedMethod = specifyInvokedMethod(methodVariations);
        if (invokedMethod.getParameterCount() == 0) {
            invokedMethod.invoke(exploredClass.newInstance(), new Class[]{});
        } else {
            Object[] args = specifyParametrsForInvMethod(invokedMethod);
            if (args != null) {
                invokedMethod.invoke(exploredClass.newInstance(), args);
            } else {
                return;
            }
        }
    }

    private ArrayList<Method> receiveMethodVariations(String methodName) {
        ArrayList<Method> methodVariations = new ArrayList<>();
        for (Method method : exploredClass.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                methodVariations.add(method);
            }
        }
        return methodVariations;
    }
}
