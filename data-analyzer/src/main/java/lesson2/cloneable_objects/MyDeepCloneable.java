package lesson2.cloneable_objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by R-Tem on 26.10.2015.
 */
public class MyDeepCloneable implements Cloneable{

    private int intField;
    private String stringField;
    private List listField;

    public int getIntField() {
        return intField;
    }
    public void setIntField(int _intField) {
        intField = _intField;
    }

    public String getStringField() {
        return stringField;
    }
    public void setStringField(String _stringField) {
        stringField = _stringField;
    }

    public List getListField() {
        return listField;
    }
    public void setListField(List _listField) {
        listField = _listField;
    }

    public MyDeepCloneable(int _intField, String _stringField) {
        intField = _intField;
        stringField = _stringField;
        listField = new ArrayList<String>();
    }

    public void addItemsToListField(String _s){
        listField.add(_s);
    }

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < listField.size(); i++) {
            s = s + listField.get(i)  + ", ";
        }
        return "intField: " + String.valueOf(intField) + "; " + "stringField: " + stringField + "\n" + s;
    }

    @Override
    public MyDeepCloneable clone(){
        MyDeepCloneable clone = null;
        try {
            clone = (MyDeepCloneable) super.clone();
            clone.listField = new ArrayList<String> (listField); // Deep cloning
            // Remember, this code will work because String is immutable,
            // otherwise you can not reply on copy Constructor provided by Collection classes,
            // they only provide shallow copy and not deep copy. If you need to deep copy a collection,
            // you need to iterate over it and clone each object separately.

        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
