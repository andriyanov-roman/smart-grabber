package lesson2.immutable_objects;

import java.util.Date;
import java.util.List;

/**
 * Created by R-Tem on 25.10.2015.
 */
public final class ImmutableKey {

    private final int i; // immutable
    private final String s; // immutable
    private final Date date; // mutable
    private final List list; // mutable

    public int getI() {
        return i;
    }
    public String getS() {
        return s;
    }
    public Date getDate() {
        return date;
    }
    public List getList() {
        return list;
    }

    public ImmutableKey(int i, String s, Date date, List list) {
        this.i = i;
        this.s = s;
        this.date = date;
        this.list = list;
    }
}
