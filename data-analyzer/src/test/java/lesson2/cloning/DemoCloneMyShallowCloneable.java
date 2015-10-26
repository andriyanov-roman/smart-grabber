package lesson2.cloning;

import lesson2.cloneable_objects.MyShallowCloneable;
import org.junit.Test;

/**
 * Created by R-Tem on 25.10.2015.
 */
public class DemoCloneMyShallowCloneable {

    MyShallowCloneable myShallowCloneable;
    MyShallowCloneable myClone;

    @Test
    public void cloneMyShallowCloneable() throws CloneNotSupportedException {
        myShallowCloneable = new MyShallowCloneable(31, "test");
        myClone = myShallowCloneable.clone();

        writeToConsole();

        myShallowCloneable.setIntField(9);
        myShallowCloneable.setStringField("Hallo World!");

        writeToConsole();

        myClone.setIntField(9);
        myClone.setStringField("Hallo World!");

        writeToConsole();
    }

    void writeToConsole () {
        System.out.println(myShallowCloneable.toString());
        System.out.println(myClone.toString());
        System.out.println("References are the same ( == ): " + (myShallowCloneable == myClone));
        System.out.println("Class is the same: " + (myShallowCloneable.getClass() == myClone.getClass()));
        System.out.println(".equals(): " + (myClone.equals(myShallowCloneable)));
        System.out.println(myShallowCloneable.hashCode());
        System.out.println(myClone.hashCode());

    }
}
