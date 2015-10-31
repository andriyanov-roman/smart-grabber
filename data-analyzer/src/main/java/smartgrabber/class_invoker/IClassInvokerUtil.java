package smartgrabber.class_invoker;

/**
 * Created by mit_OK! on 31.10.2015.
 */
public interface IClassInvokerUtil {
    String readInputData();
    void printMsg (MsgCodes msgShortCode,Object ... args);
    void printMsg (String message,Object ... args);

}
