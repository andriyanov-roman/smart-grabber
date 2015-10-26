package lesson2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by R-Tem on 25.10.2015.
 */
public class MyImmutableObject implements Cloneable{

    private int mInt;
    private String mString;
    private Date mDate;
    private ArrayList mArrayList;

    public int getInt() {
        return mInt;
    }

    public String getString() {
        return mString;
    }

    public Date getDate() {
        return mDate;
    }

    public ArrayList getArrayList() {
        return mArrayList;
    }

    public MyImmutableObject(){}
    public MyImmutableObject(int _mInt, String _mString, Date _mDate, ArrayList _mArrayList) {
        mInt = _mInt;
        mString = _mString;
        mDate = _mDate;
        mArrayList = _mArrayList;
    }

    @Override
    protected MyImmutableObject clone() throws CloneNotSupportedException {
        return (MyImmutableObject) super.clone();
    }
}
