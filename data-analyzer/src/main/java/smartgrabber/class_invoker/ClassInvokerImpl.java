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
    public static final String STRING_CANONICAL_CLASS = "java.lang.String";
    private Class<T> exploredClass;
    private ClassInvokerUtilImpl msg;

    public ClassInvokerImpl(Class<T> exploredClass) {
        this.msg = new ClassInvokerUtilImpl();
        this.exploredClass = exploredClass;
    }

    public ClassInvokerImpl() {
        this.msg = new ClassInvokerUtilImpl();
    }

    public Class<T> getExploredClass() {
        return exploredClass;
    }

    public ClassInvokerUtilImpl getMsg() {
        return msg;
    }

    public void setExploredClass(Class<T> exploredClass) {
        this.exploredClass = exploredClass;
    }

    public void printDeclaredMethods() {
        for (Method method : exploredClass.getDeclaredMethods()) {
            System.out.println(retrieveMethodInStrForm(method));
        }
    }
    private String stringifyParam(Class paramClass) {
        return paramClass.getSimpleName() + " " + paramClass.getSimpleName().toLowerCase().charAt(0);
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



    private Method specifyInvokedMethod(ArrayList<Method> methodVariations) throws NoSuchMethodException {
        Method invokedMethod;
        if (methodVariations.size() > 1) {
            msg.printMsg(MsgCodes.SELECT_METHOD_VARIATION);
            for (int i = 0; i < methodVariations.size(); i++) {
                System.out.println((i + 1) + ". " + retrieveMethodInStrForm(methodVariations.get(i)));
            }
            int selector = Integer.parseInt(msg.readInputData()) - 1;
            if (selector > methodVariations.size()) {
                throw new NoSuchMethodException();
            } else {
                invokedMethod = methodVariations.get(selector);
            }
        } else if (methodVariations.size() == 0) {
            throw new NoSuchMethodException("METHOD IS NOT SPECIFIED");
        } else {
            invokedMethod = methodVariations.get(0);
        }
        return invokedMethod;
    }

    private Object[] specifyParametersForInvMethod(Method invokedMethod) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        msg.printMsg(MsgCodes.SPECIFY_PARAMETERS, DEFAULT);
        Object[] args = new Object[invokedMethod.getParameterCount()];
        for (int i = 0; i < invokedMethod.getParameterCount(); i++) {
            Class currentParameter = invokedMethod.getParameterTypes()[i];
            String paramKey = stringifyParam(currentParameter);
            msg.printMsg(paramKey + ": ");
            Constructor paramConstructor = null;
            Boolean resultIsFind = false;
            String unresolvedParamValue = msg.readInputData();
            if (unresolvedParamValue.equals(DEFAULT)) {
                try {
                    paramConstructor = currentParameter.getConstructor(null);
                } catch (NoSuchMethodException e) {
                    msg.printMsg(MsgCodes.NO_EMPTY_CONSTRUCTOR, currentParameter.getName());
                    e.printStackTrace(System.out);
                    return null;
                }
                args[i] = paramConstructor.newInstance(null);
                break;
            } else {
                msg.printMsg(MsgCodes.SEARCH_DEFAULT_STRING_CONSTRUCTOR);
                for (Constructor constructor : currentParameter.getConstructors()) {
                    for (Class constructorParamType : constructor.getParameterTypes()) {
                        msg.printMsg(MsgCodes.WAITER);
                        if (constructorParamType.getCanonicalName().equals(STRING_CANONICAL_CLASS)) {
                            paramConstructor = constructor;
                            resultIsFind = true;
                            msg.printMsg(MsgCodes.WITH_STRING_ARGS_CONSTRUCTOR, paramConstructor.getName());
                            break;
                        }
                    }
                }
            }
            if (resultIsFind) {
                msg.printMsg(MsgCodes.RESULT_IS_FIND);
                Object paramValue = paramConstructor.newInstance(unresolvedParamValue);
                args[i] = paramValue;
            } else {
                throw new NoSuchElementException("\n\n\t\t\t\t***Can't create PARAMETER [" + paramKey + "] for method invoking***\n\n");
            }
        }
        return args;
    }

    public void invokeMethod(String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<Method> methodVariations = receiveMethodVariations(methodName);
        Method invokedMethod = specifyInvokedMethod(methodVariations);
        if (invokedMethod.getParameterCount() == 0) {
            invokedMethod.invoke(exploredClass.newInstance(), null);
        } else {
            Object[] args = specifyParametersForInvMethod(invokedMethod);
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
