package smartgrabber.class_invoker;

/**
 * Created by mit_OK! on 30.10.2015.
 */
public class ClassInvokerUtil {
    public static void printMsg (String msgShortCode){
        String msg = "";

        switch (msgShortCode) {
            case "sel":
                msg = "Select method variation:";
                break;
        }
        System.out.println(msg);
    }

}
