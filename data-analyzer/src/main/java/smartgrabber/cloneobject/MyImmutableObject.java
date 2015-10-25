package smartgrabber.cloneobject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mit_OK! on 25.10.2015.
 */
public final class MyImmutableObject implements Cloneable{
    private Date date;
    private ArrayList arrayList;

    public MyImmutableObject(Date date, ArrayList arrayList) {
        this.date = date;
        this.arrayList = arrayList;
    }

    public Date getDate() throws CloneNotSupportedException {
        MyImmutableObject clone = this.clone();
        return clone.date;
    }

    public ArrayList getArrayList() throws CloneNotSupportedException {
        MyImmutableObject clone = this.clone();
        System.out.println("Clone hashCode: "+clone.hashCode());
        return clone.arrayList;
    }

    @Override
    protected MyImmutableObject clone() throws CloneNotSupportedException {
        return new MyImmutableObject(date,arrayList);
    }
}
