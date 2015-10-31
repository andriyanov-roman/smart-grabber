package lesson2.method_invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by R-Tem on 30.10.2015.
 */
public class MethodInvoker<T> {

    private Object instance;
    private String methodName;
    private Class parameterClass;
    private Object parameter;

    public MethodInvoker(Object instance, String methodName) {
        this.instance = instance;
        this.methodName = methodName;
    }

    public MethodInvoker(Object instance, String methodName, Class parameterClass, Object parameter){
        this.instance = instance;
        this.methodName = methodName;
        this.parameterClass = parameterClass;
        this.parameter = parameter;
    }

    public Object invoke(){
        Method method = null;
        try {
            if (parameterClass == null){
                method = instance.getClass().getDeclaredMethod(methodName);
            } else method = instance.getClass().getDeclaredMethod(methodName, parameterClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        try {
            if (parameterClass == null){
                return method.invoke(instance);
            } else return method.invoke(instance, parameter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
