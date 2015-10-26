package lesson2.cloneable_objects;

/**
 * Created by R-Tem on 26.10.2015.
 */
public class MyShallowCloneable implements Cloneable{

    private int intField;
    private String stringField;

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

    public MyShallowCloneable(){}
    public MyShallowCloneable(int _intField, String _stringField) {
        intField = _intField;
        stringField = _stringField;
    }

    @Override
    public String toString() {
        String s = "intField: " + String.valueOf(intField) + "; " + "stringField: " + stringField;
        return s;
    }

    @Override
    public MyShallowCloneable clone() throws CloneNotSupportedException{
        return (MyShallowCloneable) super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyShallowCloneable other = (MyShallowCloneable) obj;
        if (this.intField != other.intField) {
            return false;
        }
        if (this.stringField != other.stringField) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + intField;
        result = prime * result + stringField.hashCode();
        return result;
    }
}
