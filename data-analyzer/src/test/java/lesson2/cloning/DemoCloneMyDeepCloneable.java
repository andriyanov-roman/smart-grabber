package lesson2.cloning;

import lesson2.cloneable_objects.MyDeepCloneable;
import org.junit.Test;

/**
 * Created by R-Tem on 26.10.2015.
 */
public class DemoCloneMyDeepCloneable {

    MyDeepCloneable myDeepCloneable;
    MyDeepCloneable myClone;

    @Test
    public void cloneMyDeepCloneable(){
        myDeepCloneable = new MyDeepCloneable(6, "proff_3");
        myDeepCloneable.addItemsToListField("Roma");
        myDeepCloneable.addItemsToListField("Misha");
        myDeepCloneable.addItemsToListField("Dima");
        myDeepCloneable.addItemsToListField("Alisa");
        myDeepCloneable.addItemsToListField("Artem");
        myDeepCloneable.addItemsToListField("Vlas");

        myClone = myDeepCloneable.clone();

        writeToConsole();
    }

    void writeToConsole(){
        System.out.println(myDeepCloneable.toString());
        System.out.println(myClone.toString());
        System.out.println("(myDeepCloneable.getListField().get(0) == myClone.getListField().get(0)): "
                + (myDeepCloneable.getListField().get(0) == myClone.getListField().get(0)));
    }
}
