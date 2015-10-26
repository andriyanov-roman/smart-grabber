package cloning;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by R-Tem on 25.10.2015.
 */
public class MyImmutableObject {

    private int mInt;
    private String mString;
    private Date mDate;
    private ArrayList mArrayList;

    public int getmInt() {
        return mInt;
    }

    public String getmString() {
        return mString;
    }

    public Date getmDate() {
        return mDate;
    }

    public ArrayList getmArrayList() {
        return mArrayList;
    }

    public MyImmutableObject(){}
    public MyImmutableObject(int _mInt, String _mString, Date _mDate, ArrayList _mArrayList) {
        mInt = _mInt;
        mString = _mString;
        mDate = _mDate;
        mArrayList = _mArrayList;
    }

}
