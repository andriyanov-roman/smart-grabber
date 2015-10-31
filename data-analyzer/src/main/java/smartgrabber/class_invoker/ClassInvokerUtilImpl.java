package smartgrabber.class_invoker;

import java.util.Scanner;

/**
 * Created by mit_OK! on 30.10.2015.
 */
public class ClassInvokerUtilImpl implements IClassInvokerUtil {
    private Scanner scanner = new Scanner(System.in);

    public ClassInvokerUtilImpl() {
    }

    public String readInputData() {
        return scanner.nextLine();
    }

    public void printMsg(MsgCodes msgCode, Object... args) {
        String msg = "";
        switch (msgCode) {
            case SELECT_METHOD_VARIATION:
                msg = "Select method variation:";
                break;
            case SPECIFY_PARAMETERS:
                msg = "Specify parameters (type '" + args[0] +
                        "' to use Default Constructor on your own risk!):";
                break;
            case NO_EMPTY_CONSTRUCTOR:
                msg = "\n\t\t>>>" + args[0] + " DOESN'T HAVE EMPTY CONSTRUCTOR!\n" +
                        "\t\t>>> I WARNED !!!\n\n ";
                break;
            case SEARCH_DEFAULT_STRING_CONSTRUCTOR:
                msg = "\t\t\tSearching for default STRING constructor";
                break;
            case WAITER:
                System.out.print(".");
                break;
            case WITH_STRING_ARGS_CONSTRUCTOR:
                msg = "[" + args[0] + "(String s)]";
                break;
            case RESULT_IS_FIND:
                msg = "\t\tGot it!";
                break;

        }
        if (!msg.equals("")) {
            System.out.println(msg);
        }
    }

    @Override
    public void printMsg(String message, Object... args) {
        System.out.print(message + " ");
        for (Object o : args) {
            System.out.print(o);
        }
        System.out.println();
    }


}
